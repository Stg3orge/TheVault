
/**
 * @author fen
 *
 */
import java.util.*;

public class Bottle implements Observable {

	private int amount;
	private Collection<Observer> observers;

	public Bottle() {

		this.amount = 0;
		this.observers = new LinkedList<>();
	}

	public void changeAmount(int amount) {
		this.amount = amount;
		notifyObservers();
	}

	@Override
	public void notifyObservers() {
		for (Observer o : observers) {
			o.notifyMe(amount);
		}
	}

	@Override
	public void addObserver(Observer obs) {
		observers.add(obs);
	}

	@Override
	public void removeObser(Observer obs) {
		observers.remove(obs);
	}

}
