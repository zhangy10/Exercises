package Graph;

import java.util.List;

/**
 * 
 * @author zhangy10 671205
 *
 *         Sep 1, 2015
 *
 *         GraphTravel.java
 *         
 *         Abstract super class
 *         Designing for covering different kinds of graph traveling algorithms
 */
public abstract class GraphTravel {
	protected Graph graph;
	protected List<Node> vertexs;
	protected int complexity = 0;

	public int getComplexity() {
		return complexity;
	}

	public Graph getGraph() {
		return graph;
	}

	public List<Node> getVertexs() {
		return vertexs;
	}

	public GraphTravel(int size) {
		graph = new GraphMatrix(size);
		vertexs = graph.getVertexs();
	}

	public void resetGraph() {
		complexity = 0;
		for (int i = 0; i < vertexs.size(); i++) {
			vertexs.get(i).state = GraphState.NON_VISITED;
		}
	}

	/**
	 * Marking the node has been visited
	 * 
	 * @param n current node
	 */
	protected void visitedNode(Node n) {
		n.state = GraphState.VISITED;
		System.out.print((n.vaule + 1) + " ");
	}
}
