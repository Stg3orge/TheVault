package mealy;

import java.util.function.Predicate;

/**
 * 
 * @author knol
 * @version 20180420
 *
 * @param <T>
 */
public class Edge<T> {
	private String label;
	private Predicate<T> guard;
	private Runnable action;
	private State<T> to;
	
	public Edge(State<T> to, Predicate<T> guard, String guardLabel, Runnable action) {
		this.to = to;
		this.guard = guard;
		this.label = guardLabel;
		this.action = action;
	}

	public Predicate<T> getGuard() {
		return guard;
	}
	
	public String getGuardLabel() {
		return label;// TODO - label should maybe be moved into a Guard class that also implements Predicate<T>
	}

	public State<T> getTo() {
		return to;
	}

	public void action() {
		if(action != null) {
			action.run();
		}
	}

}
