package model;

public class BalanceUnderrunException extends IllegalArgumentException {

	private static final long serialVersionUID = 2511866234493682589L;

	public BalanceUnderrunException(String message) {
		super(message);
	}

}
