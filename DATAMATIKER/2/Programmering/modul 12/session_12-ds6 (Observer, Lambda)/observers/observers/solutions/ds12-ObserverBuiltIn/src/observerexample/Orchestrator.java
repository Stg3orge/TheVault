package observerexample;

import java.util.Observable;
import java.util.Observer;

/**
 * This class is not part of the pattern - or rather - it's the "surroundings". 
 * We use it to set up the observers and the observables, and simulate that the system works.
 * @author knol
 *
 */
public class Orchestrator {
	public static void main(String[] args) {
		Observable obleBanana = new ObservableProduct("Banana", 10d);
		Observable obleNaranja = new ObservableProduct("Orange", 5d);
		
		Observer joe = new ObserverCustomer("Joe");
		Observer jane = new ObserverCustomer("Jane");
		
		obleBanana.addObserver(joe);
		obleNaranja.addObserver(jane);
		obleBanana.addObserver(jane);
		
		((ObservableProduct)obleBanana).setPrice(5d);     // Overproduction of banana
		System.out.println("****\n* Check hasChanged: " + obleBanana.hasChanged() + "\n****\n");
		((ObservableProduct)obleNaranja).setPrice(100d); // Orange shortage
		((ObservableProduct)obleBanana).setPrice(50d);     // Banana prices soar
	}
}
