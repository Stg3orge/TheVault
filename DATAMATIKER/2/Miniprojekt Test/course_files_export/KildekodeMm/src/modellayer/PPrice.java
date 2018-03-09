package modellayer;

/**
 * Inspired by the book: Flexible, Reliable Software
 * Henrik Bærbak Christensen: Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class PPrice {
	
	// Parkingtime in seconds / 1 cent (Currency: Euro)
	private int parkingPrice;	
	// Price depends on the pay stations parkingzone
	private PZone parkingZone;	
	// Exchange rate 1 Euro to DKK
	private double exchangeEuroDkk;

	// Hard coded values
	public PPrice() {
		this.parkingPrice = 24;
		this.parkingZone = new PZone();
		this.exchangeEuroDkk = 7.5;
	}

	public PPrice(int parkingPrice, PZone parkingZone) {
		this.parkingPrice = parkingPrice;
		this.parkingZone = parkingZone;
	}
	
	public PPrice(int parkingPrice, PZone parkingZone, double exchangeEuroDkk) {
		this.parkingPrice = parkingPrice;
		this.parkingZone = parkingZone;
		this.exchangeEuroDkk = exchangeEuroDkk;
	}

	public int getParkingPrice() {
		return parkingPrice;
	}

	public void setParkingPrice(int parkingPrice) {
		this.parkingPrice = parkingPrice;
	}

	public PZone getParkingZone() {
		return parkingZone;
	}

	public void setParkingZone(PZone parkingZone) {
		this.parkingZone = parkingZone;
	}

	public double getExchangeEuroDkk() {
		return exchangeEuroDkk;
	}

	public void setExchangeEuroDkk(double exchangeEuroDkk) {
		this.exchangeEuroDkk = exchangeEuroDkk;
	}
	
}
