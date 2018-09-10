import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.TreeMap;

public class LinkedGraph implements GraphIF {
	private int initSize;
	private List<Vertex> vertices;
	private List<LinkedList<Vertex>> adjList;

	public LinkedGraph() {
		init(10);
	}
	
	public LinkedGraph(int noVer) {
		init(noVer);
	}

	private void init(int vertexCount) {
		initSize = vertexCount;
		vertices = new ArrayList<Vertex>(initSize);
		adjList = new ArrayList<LinkedList<Vertex>>(initSize);
	}
	
	@Override
	public void clear() {
		init(initSize);
	}

	@Override
	public boolean isEmpty() {
		return getVertexCount() == 0;
	}

	@Override
	public int getVertexCount() {
		int res = 0;
		if(vertices != null) {
			res = vertices.size();
		}
		return res;
	}

	@Override
	public int getEdgeCount() {
		int res = 0;
		if(adjList != null) {
			for(int i = 0 ; i < adjList.size(); i++) {
				res += adjList.get(i).size(); // no NPE check, as other methods maintain class invariant of adjacency lists not being null
			}
		}
		return res;
	}

	@Override
	public int getSize() {
		return getEdgeCount() + getVertexCount();
	}

	
	@Override
	public void addVertex(Vertex vertex) {
		vertices.add(vertex);
		adjList.add(new LinkedList<Vertex>());
	}

	@Override
	public boolean containsVertex(Vertex v) {
		return vertices.indexOf(v) > -1;
	}

	@Override
	public void addEdge(Vertex from, Vertex to) {
		if(!containsVertex(from) || !containsVertex(to)) {
			throw new IllegalArgumentException("At least one of the end points of the edge is not in the graph");
		}
		if(isAdjacent(from, to)) {
			throw new IllegalArgumentException(from.getName() + " and " + to.getName() + " are already adjacent!");
		}
		int index = vertices.indexOf(from);
		adjList.get(index).add(to);
	}

	@Override
	public boolean isAdjacent(Vertex from, Vertex to) {
		int index = vertices.indexOf(from);
		return adjList.get(index).contains(to);
	}

	@Override
	public List<Vertex> getAdjacencies(Vertex v) {
		int index = vertices.indexOf(v);
		List<Vertex> res = null;
		if(index >= 0) {
			res = new LinkedList<Vertex>(this.adjList.get(index)); 
		}
		return res;
	}

	@Override
	public void unMarkAll() {
		for(Vertex v : vertices) {
			v.setMarked(false);
		}
	}
	
	@Override
	public void markAll() {
		for(Vertex v : vertices) {
			v.setMarked(false);
		}
	}


	@Override
	public void dfs(Vertex v) {
		System.out.println(v.getName());
		v.setMarked(true);
		List<Vertex> adjacencies = getAdjacencies(v);
		for(Vertex currV : adjacencies) {
			if(!currV.isMarked()) {
				dfs(currV);
			}
		}
	}

	@Override
	public void bfs(Vertex v) {
		Queue<Vertex> queue = new LinkedList<>();
		queue.add(v); //enqueue
		while(!queue.isEmpty()) {
			Vertex currV = queue.poll();
			currV.setMarked(true);
			System.out.println(currV.getName());
			List<Vertex> adjacencies = getAdjacencies(currV);
			for(Vertex adjV : adjacencies) {
				if(! adjV.isMarked()) {
					queue.add(adjV);
				}
			}
		}
	}






}