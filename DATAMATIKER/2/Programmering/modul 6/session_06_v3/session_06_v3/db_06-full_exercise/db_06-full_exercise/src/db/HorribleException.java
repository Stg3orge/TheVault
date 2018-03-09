package db;

public class HorribleException extends Exception {
	public HorribleException(Exception e, String expl) {
		super(expl, e);
	}
}
