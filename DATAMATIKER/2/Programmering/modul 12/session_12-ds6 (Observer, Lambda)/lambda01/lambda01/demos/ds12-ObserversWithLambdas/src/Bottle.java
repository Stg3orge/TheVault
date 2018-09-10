
/**
 * @author fen
 *
 */
import java.util.*;
import java.util.function.Consumer;

public class Bottle {

	private int amount;
	private Collection<Consumer<Integer>> observers;

	public Bottle() {

		this.amount = 0;
		this.observers = new LinkedList<>();
	}

	public void changeAmount(int amount) {
		this.amount = amount;
		notifyObservers();
	}

	public void fillBottle() {
		amount = 70;
		notifyObservers();
	}

	public void notifyObservers() {
		for (Consumer<Integer> observer : observers) {
			observer.accept(amount);
		}
	}

	public void addObserver(Consumer<Integer> obs) {
		observers.add(obs);
	}

	public void removeObser(Consumer<Integer> obs) {
		observers.remove(obs);
	}

}
