import java.util.List;

public interface GraphIF {

	void addVertex(Vertex v);

	boolean isEmpty();

	int getVertexCount();

	int getEdgeCount();

	int getSize();

	boolean containsVertex(Vertex v);

	void addEdge(Vertex from, Vertex to);

	boolean isAdjacent(Vertex from, Vertex to);

	List<Vertex> getAdjacencies(Vertex v);

	void unMarkAll();
	
	void markAll();
	
	void dfs(Vertex v);
	
	void bfs(Vertex v);

	void clear();

}