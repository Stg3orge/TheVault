package model;

import java.util.ArrayList;
import java.util.List;

public class ProductContainer {
	private List<Product> products;
	private static ProductContainer instance;
	private ProductContainer() {
		products = new ArrayList<>();
	}
	
	public static ProductContainer getInstance() {
		if(instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}
	
	public void addProduct(Product p) {
		products.add(p);
	}
	
	public Product findById(int id) {
		Product res = null;
		for(int i = 0 ; i < products.size() && res == null; i++) {
			if(products.get(i).getId() == id) {
				res = products.get(i);
			}
		}
		return res;
	}

	public static void reset() {
		instance = null;		
	}
}
