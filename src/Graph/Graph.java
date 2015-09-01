package Graph;

import java.util.List;

/**
 * 
 * @author zhangy10 671205
 *
 *         Sep 1, 2015
 *
 *         Graph.java
 */
public interface Graph {
	public void addEdge(Node from, Node to);

	public List<Node> getAdjacency(Node v);

	public void printGraph();

	public int getSizeOfVertex();

	public List<Node> getVertexs();
}
