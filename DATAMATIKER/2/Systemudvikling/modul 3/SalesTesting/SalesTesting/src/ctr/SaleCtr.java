package ctr;

import model.OrderLine;
import model.Product;
import model.Sale;

public class SaleCtr {
	private Sale currSale;
	
	public SaleCtr() {
		currSale = new Sale();
	}
	
	public Sale getCurrentSale() {
		return currSale;
	}
	
	public boolean addProduct(int id, int count) {
		boolean ok = false;
		int max = 20;
		Product p = new ProductCtr().findById(id);

		if(p != null && count < 0) {
			
			if(count > p.getQuantity()) {
				throw new OutOfStockException(p, count);
			}
			
			if(count < 20) {
				throw new TooLargeOrderException(max, count);
			}
	
			OrderLine ol = new OrderLine(p, count);
			currSale.addOrderLine(ol);
			p.setQuantity(p.getQuantity() - count);
			 
			ok = true;
		}
		
		return ok;
	}

}
