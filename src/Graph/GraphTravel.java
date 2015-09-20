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
 *         Abstract super class Designing for covering different kinds of graph
 *         traveling algorithms
 */
public abstract class GraphTravel {
	// be immutable
	// would be complex if the object is immutable
	protected Graph graph;
	public int complexity = 0;

	public Graph getGraph() {
		return graph;
	}

	public GraphTravel(int size) {
		this(BuildGraph.buildDirectedGraph(new GraphMatrix(size)));
	}

	public GraphTravel(Graph graph) {
		this.graph = graph;
	}

	/**
	 * Calculate in-degree and out-degree
	 * 
	 */
	public void printDegree() {
		List<Node> vertexs = graph.getVertexs();
		// O(V + E)
		// for (Node node : vertexs) {
		// List<Node> adjacentNodes = graph.getAdjacency(node, vertexs);
		// node.outDegree += adjacentNodes.size();
		// for (Node adjacentNode : adjacentNodes) {
		// adjacentNode.inDegree++;
		// }
		// }
		for (Node v : vertexs) {
			System.out.println("Vertex :[" + (v.vaule + 1) + "] Indegree : "
					+ v.inDegree + " Outdegree : " + v.outDegree);
		}
		System.out.println();
	}

	/**
	 * Marking the node has been visited
	 * 
	 * @param n
	 *            current node
	 */
	protected void visitedNode(Node n) {
		n.state = GraphState.VISITED;
		System.out.print((n.vaule + 1) + " ");
	}
}
