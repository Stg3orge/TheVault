package ctr;

import model.Product;
import model.ProductContainer;

public class ProductCtr {

	public Product findById(int id) {

		return ProductContainer.getInstance().findById(id);
	}

}
