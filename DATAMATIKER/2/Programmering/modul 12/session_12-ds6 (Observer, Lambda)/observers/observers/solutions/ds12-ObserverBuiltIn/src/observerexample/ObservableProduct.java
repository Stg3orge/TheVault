package observerexample;

import java.util.Observable;

/**
 * Example class that implements the observer pattern using the built-in class and interface<br>
 * 1. Extend the Observable super class (from java.util)<br>
 * 2. Add properties to the class.<br>
 * 3. Decide what property change should trigger the observable behavior<br>
 * 4. On any change, make sure that the observable behavior is triggered (set state changed)<br><br>
 * This class can be watched wrt price changes
 * @author knol
 *
 */
public class ObservableProduct extends Observable {
	private String name;
	private double price;
	public ObservableProduct(String name, double price) {
		super();
		this.name = name;
		this.price = price;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		double oldPrice = this.price;
		this.price = price;		// update price here --> the observer will see the NEW price
		if(oldPrice != price) {
			super.setChanged();
			super.notifyObservers(price);
			//super.clearChanged(); // This happens by itself, but we may want to use it to modify (override) functionality
		}
		//this.price = price;	// update price here --> the observer will see the OLD price
	}
	@Override
	public String toString() {
		return "ObservableProduct [name=" + name + ", price=" + price + "]";
	}
	
	
}
