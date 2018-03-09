package model;

public class DuplicateAccountNameException extends IllegalArgumentException {
	private static final long serialVersionUID = 9087755743952676967L;

	public DuplicateAccountNameException(String message) {
		super(message);
	}
}
