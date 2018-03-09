package controllayer;

/**
 * Inspired by the book: Flexible, Reliable Software
 * Henrik Bærbak Christensen: Flexible, Reliable Software. Taylor and Francis Group, LLC 2010
 */

public class Coin {

	public static void testCoin(int coinValue, Currency.ValidCurrency currency, Currency.ValidCoinType coinType) throws IllegalCoinException {

		if (currency == Currency.ValidCurrency.EURO) {
			boolean euroCoinOk = false;
			if (coinType == Currency.ValidCoinType.FRACTION) {
				euroCoinOk = testCentCoin(coinValue);
			}
			if (coinType == Currency.ValidCoinType.INTEGER) {
				euroCoinOk = testEuroCoin(coinValue);
			}
			if (!euroCoinOk) {
				throw new IllegalCoinException("Invalid Euro coin: " + coinValue);
			}
		} else if (currency == Currency.ValidCurrency.DKK) {
			boolean dkkCoinOk = false;
			if (coinType == Currency.ValidCoinType.FRACTION) {
				dkkCoinOk = testOreCoin(coinValue);
			}
			if (coinType == Currency.ValidCoinType.INTEGER) {
				dkkCoinOk = testDkkCoin(coinValue);
			}
			if (!dkkCoinOk) {
				throw new IllegalCoinException("Invalid Dkk coin: " + coinValue);
			}
		} else {
			throw new IllegalCoinException("Invalid coin: " + coinValue);
		}
	}

	private static boolean testCentCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 1:
			case 2:
			case 5:
			case 10:
			case 20:
			case 50:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}
	
	private static boolean testEuroCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 1:
			case 2:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}	
	
	private static boolean testOreCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 50:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}
	
	private static boolean testDkkCoin(int coinValue) {
		boolean coinIsOk = true;
		switch (coinValue) {
			case 1:
			case 2:
			case 5:
			case 10:
			case 20:
				break;
			default:
				coinIsOk = false;
		}
		return coinIsOk;
	}		

}
