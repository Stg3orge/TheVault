package controllayer;

import java.time.LocalDate;

import modellayer.*;
import databaselayer.DatabaseLayerException;
import databaselayer.DbPBuy;
import databaselayer.DatabasePBuy;

/**
 * Inspired by the book: Flexible, Reliable Software Henrik Bærbak Christensen:
 * Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class ControlPayStation {

	private double insertedSoFar;
	private int timeBought;

	// Receive one coin as input
	public void addPayment(int coinValue, Currency.ValidCurrency currency, Currency.ValidCoinType coinType) throws IllegalCoinException {
		
		// Test if coin is valid
		try {
			Coin.testCoin(coinValue, currency, coinType);
		} catch (IllegalCoinException coinError) {
			throw new IllegalCoinException(
					"Invalid coin: " + currency.toString() + ", " + coinType.toString() + ", " + coinValue);
		}
		
		// Get inserted so far in cents
		insertedSoFar += GetCoinValueInCent(coinValue, currency, coinType);
		// Calculate the corresponding parking time in minutes (calculated seconds and convert to minutes - rounded up)
		PPrice aPrice = new PPrice();
		timeBought = GetTimeBoughtInMinutes(insertedSoFar, aPrice);
	}

	// Process the buy
	public PReceipt buy() throws DatabaseLayerException {
		LocalDate currentTime = java.time.LocalDate.now();
		// create buy
		PBuy thisBuy = new PBuy(currentTime, timeBought, insertedSoFar);
		PPayStation pStat = new PPayStation(1, "P-423E");
		thisBuy.setAssociatedPaystation(pStat);
		// Save in Parkingsystem db
		DbPBuy dbBuy = new DatabasePBuy();
		dbBuy.insertParkingBuy(thisBuy);
		//
		ControlReceipt ctrlReceipt = new ControlReceipt(timeBought);
		reset();		
		PReceipt buyReceipt = ctrlReceipt.getParkingReceipt();		
		return buyReceipt;
	}

	public int readDisplay() {
		return timeBought;
	}	
	
	public void setReady() {
		reset();
	}

	public void cancel() {
		reset();
	}

	private void reset() {
		insertedSoFar = 0;
		timeBought = 0;
	}
	
	
	private double GetCoinValueInCent(double coinValue, Currency.ValidCurrency currency,
			Currency.ValidCoinType coinType) {
		double valueInCent = 0;

		if (currency == Currency.ValidCurrency.DKK) {
			PPrice nowPrice = new PPrice();
			valueInCent = getDkkCoinValueInCent(coinValue, coinType, nowPrice);
		} else {
			valueInCent = getEuroCoinValueInCent(coinValue, coinType);
		}

		return valueInCent;
	}

	private int GetTimeBoughtInMinutes(double accumulatedAmountInCent, PPrice usePrice) {
		int timeBoughtInMinutes = 0;

		double timeBoughtInSeconds = accumulatedAmountInCent * usePrice.getParkingPrice();
		timeBoughtInMinutes = (int) ((timeBoughtInSeconds + 59) / 60);

		return timeBoughtInMinutes;
	}

	private double getEuroCoinValueInCent(double coinValue, Currency.ValidCoinType coinType) {
		double valueInCent = 0;

		if (coinType == Currency.ValidCoinType.INTEGER) {
			valueInCent = coinValue * 100;
		} else {
			valueInCent = coinValue;
		}

		return valueInCent;
	}

	private double getDkkCoinValueInCent(double coinValue, Currency.ValidCoinType coinType, PPrice price) {
		double valueInCent = 0;

		if (coinType == Currency.ValidCoinType.INTEGER) {
			valueInCent = (coinValue * 100) / price.getExchangeEuroDkk();
		} else {
			valueInCent = coinValue / price.getExchangeEuroDkk();
		}

		return valueInCent;
	}	

}
