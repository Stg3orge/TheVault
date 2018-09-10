package mealy;

import java.util.ArrayList;
import java.util.List;

public class State<T> {
	private String name;
	private List<Edge<T>> edges;

	public State(String name) {
		if(name == null) {
			throw new IllegalArgumentException("The state name must not be null");
		}
		this.name = name;
		this.edges = new ArrayList<>(1);
	}

	public String getName() {
		return name;
	}

	public List<Edge<T>> getEdges() {
		return edges;
	}

	public void addEdge(Edge<T> e) {
		edges.add(e);
	}

}
