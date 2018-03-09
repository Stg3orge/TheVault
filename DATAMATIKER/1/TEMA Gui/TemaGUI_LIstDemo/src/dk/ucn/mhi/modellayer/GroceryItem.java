package dk.ucn.mhi.modellayer;

public class GroceryItem {
	private String name;
	private double quantity;
	
	/**
	 * Create the object based on both description and quantity
	 * @param description the describing name for the item
	 * @param quantity how many of a given item is ordered
	 */
	public GroceryItem(String description, double quantity) {
		this.name = description;
		this.quantity = quantity;
	}

	public double getQuantity() {
		return quantity;
	}

	public void setQuantity(double quantity) {
		this.quantity = quantity;
	}

	public String getName() {
		return name;
	}

	
	

}
