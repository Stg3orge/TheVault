package ctr;

public class TooLargeOrderException extends RuntimeException {
	private int max;
	private int desired;
	
	public TooLargeOrderException(int max, int desired)  {
		this.max = max;
		this.desired = desired;
	}
	
	@Override
	public String getMessage() {
		return "Too Large Order - Max allowed: " + max + ", desired: " + "desired";
	}
}
