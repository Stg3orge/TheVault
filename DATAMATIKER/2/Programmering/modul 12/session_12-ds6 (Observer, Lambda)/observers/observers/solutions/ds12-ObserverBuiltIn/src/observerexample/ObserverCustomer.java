package observerexample;

import java.util.Observable;
import java.util.Observer;

/**
 * Implement the observer pattern using the built-in class and interface.<br>
 * 1. Implement the Observer interface<br>
 * 2. Implement the update(o,o) method as required by the interface<br>
 * The update(o,o) method implements "what the observer should do when it is notified about a change in 
 * the observed object's state".
 * @author knol
 *
 */
public class ObserverCustomer implements Observer {
	private String name;
	public ObserverCustomer(String name) {
		super();
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}


	@Override
	public void update(Observable o, Object arg) {
		System.out.println("I, " + name + ", just got an update "
				+ "\n   from: " + ((ObservableProduct)o).getName() + 
				  "\n   with news: " + arg);
		System.out.println("    ... Therefore, I'll check out the observable: " + o.toString() + "\n");
	}


}
