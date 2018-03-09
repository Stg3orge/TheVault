package model;

import java.util.ArrayList;
import java.util.List;

public class Sale {

	private List<OrderLine> orderLines;
	
	public Sale() {
		orderLines = new ArrayList<>();
	}

	public void addOrderLine(OrderLine ol) {
		this.orderLines.add(ol);
	}
	
	public List<OrderLine> getOrderLines() {
		return new ArrayList<OrderLine>(orderLines);
	}

}
