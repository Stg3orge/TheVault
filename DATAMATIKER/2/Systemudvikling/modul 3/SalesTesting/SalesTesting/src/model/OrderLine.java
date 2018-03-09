package model;

public class OrderLine {

	private Product p;
	private int count;

	public OrderLine(Product p, int count) {
		this.p = p;
		this.count = count;
	}

	public Product getProduct() {
		return p;
	}

	public int getCount() {
		return count;
	}

}
