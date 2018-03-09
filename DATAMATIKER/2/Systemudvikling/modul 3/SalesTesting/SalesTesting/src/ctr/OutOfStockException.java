package ctr;

import model.Product;

public class OutOfStockException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	private int desiredQty;
	private Product p;
	
	public OutOfStockException(Product p, int desiredQty) {
		this.p = p;
		this.desiredQty = desiredQty;
	}

	public int getDesiredQty() {
		return desiredQty;
	}

	public Product getP() {
		return p;
	}
	
	@Override
	public String getMessage() {
		return "Product " + p.getDescription() + " has less in stock than desired " + p.getQuantity() +  " instead of " + desiredQty;
	}

}
