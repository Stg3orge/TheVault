package mealy;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.Predicate;

/**
 * Implements a determenistic finite state machine. This is a Mealy machine,
 * guards and actions are associated with the transitions.
 * 
 * @author knol
 * @version 20180420
 * 
 * @param <T>
 *            defines the single input to the gueards on the transitions
 */
public class DeterministicMealyMachine<T> {
	private class TraceRecord<T> {
		private State<T> from, to;
		private Edge<T> transition;
		private T input;
		private String message;

		private TraceRecord(State<T> from, State<T> to, Edge<T> transition, T input, String message) {
			this.from = from;
			this.to = to;
			this.transition = transition;
			this.input = input;
			this.message = message;
		}

		private String getRecordString() {
			return "" + (message != null ? message : "") + (from != null ? from.getName() : "null") + " --" + "(["
					+ (transition == null ? "?" : transition.getGuard() == null ? "?" : transition.getGuardLabel())
					+ "] (" + input + ") =>" + (transition != null ? transition.getGuard().test(input) : "null")
					+ ")--> " + (to != null ? to.getName() : "null");
		}
	}

	private void addToTrace(State<T> from, State<T> to, Edge<T> edge, T t, String message) {
		TraceRecord<T> tr = new TraceRecord<T>(from, to, edge, t, message);
		trace.add(tr);
	}

	public void printTrace() {
		System.out.println("Trace:");
		for (TraceRecord<T> tr : trace) {
			System.out.println(tr.getRecordString());
		}
	}

	private List<TraceRecord<T>> trace;
	private Map<String, State<T>> states;
	private State<T> start, currentState;
	private Set<State<T>> accept;
	private boolean validStructure;
	private boolean validState;

	public DeterministicMealyMachine() {
		reset();
	}

	public final void reset() {
		states = new HashMap<>(1);
		accept = new HashSet<>(1);
		start = null;
		validStructure = false;
		rewind();
	}

	public final void rewind() {
		validState = true;
		trace = new LinkedList<>();
		currentState = start;
	}

	private void validate() throws InvalidStructureException {
		validStructure = true; // validate
		if (start == null) {
			validStructure = false;
			throw new InvalidStructureException("No start state defined");
		}
		// TODO do more validation. Are all states reachable? Are there accept states?
		// Must there be accept states at all?
	}

	public boolean read(T t) throws InvalidStructureException {
		if (currentState == null) {
			currentState = start;
		}
		if (!validStructure) {
			validate();// throws invalid structure exception
		}
		if (validStructure && validState) {
			List<Edge<T>> validOuts = findValidOuts(t);
			if (validOuts.size() == 0) {
				// No valid outgoing edges
				validState = false;
				addToTrace(currentState, null, null, t, "ERR: No matching transition");
			} else if (validOuts.size() > 1) {
				// Nondeterministic behaviour
				validState = false;
				for (Edge<T> e : validOuts) {
					addToTrace(currentState, e.getTo(), e, t, "ERR: Too many valid outgoing states (nondeterministic)");
				}
			} else {
				validOuts.get(0).action();
				addToTrace(currentState, validOuts.get(0).getTo(), validOuts.get(0), t, null);
				currentState = validOuts.get(0).getTo();
			}
		}
		return validState;
	}

	private List<Edge<T>> findValidOuts(T t) {
		List<Edge<T>> res = new LinkedList<>();
		for (Edge<T> e : currentState.getEdges()) {
			if (e.getGuard().test(t)) {
				res.add(e);
			}
		}
		return res;
	}

	public void addState(String name, boolean start, boolean accept) throws IllegalArgumentException {
		if (this.states.containsKey(name)) {
			throw new IllegalArgumentException("The state machine already contains a state named " + name);
		}
		State<T> state = new State<>(name);
		if (start) {
			setStartState(name);
		}
		if (accept) {
			addAcceptState(name);
		}
		if (!start && !accept) {
			states.put(name, state);
		}
	}

	public void addState(String name) {
		addState(name, false, false);
	}

	/**
	 * Sets an existing state with stateName to start or adds a new state with the
	 * name as accept state. A possible previous accept state is turned into an
	 * ordinary state.
	 * 
	 * @param stateName
	 * @throws IllegalArgumentException
	 */
	public void setStartState(String stateName) throws IllegalArgumentException {
		State<T> state = states.get(stateName); // TODO refactor setStartState and addAcceptState, as they share a few
												// lines of reduncant code
		if (state == null) {
			state = new State<>(stateName);
			states.put(stateName, state);
		}
		start = state;
	}

	/**
	 * If state with stateName exists, it is turned into an accept state. if such a
	 * state does not exist, a new state is created and made an accept state.
	 * 
	 * @param stateName
	 */
	public void addAcceptState(String stateName) {
		State<T> state = states.get(stateName);
		if (state == null) {
			state = new State<>(stateName);
			states.put(stateName, state);
		}
		accept.add(state);
	}

	public void makeNotAcceptState(String stateName) {
		State<T> state = states.get(stateName);
		if (state != null) {
			accept.remove(state);
		}
	}

	public void addTransition(String stateFrom, String stateTo, Predicate<T> guard, String guardLabel,
			Runnable action) {
		State<T> from = states.get(stateFrom);
		State<T> to = states.get(stateTo);
		if (from == null) {
			throw new IllegalArgumentException("No state exists with name " + stateFrom);
		}
		if (to == null) {
			throw new IllegalArgumentException("No state exists with name " + stateTo);
		}
		if (guard == null) {
			throw new IllegalArgumentException("A guard must always be provided (guard was null)");
		}
		Edge<T> e = new Edge<>(to, guard, guardLabel, action);
		from.addEdge(e);
	}

	public boolean accept(T... t) {
		rewind();
		boolean ok = validState;
		validate();
		for (int i = 0; ok && i < t.length; i++) {
			ok = read(t[i]);
		}
		return isAccept();
	}

	public boolean isAccept() {
		return accept.contains(currentState) && isValidState() && currentState != null;
	}

	public boolean isValidState() {
		return validState;
	}

}
