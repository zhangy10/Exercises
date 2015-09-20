package Graph;

import java.util.ArrayList;
import java.util.List;

public final class BuildGraph {

	public static Graph buildDirectedGraph(Graph graph) {
		if (graph == null) {
			return null;
		}

		List<Node> vNodes = graph.getVertexs();
		
		// according to the size of vertexes to build each edge 
		// Testing Graph 1 <V,E> = <7, 9>
		// initaledGraph.addEdge(vNodes.get(0), vNodes.get(1));
		// initaledGraph.addEdge(vNodes.get(0), vNodes.get(2));
		// initaledGraph.addEdge(vNodes.get(0), vNodes.get(3));
		// initaledGraph.addEdge(vNodes.get(1), vNodes.get(4));
		// initaledGraph.addEdge(vNodes.get(2), vNodes.get(4));
		// initaledGraph.addEdge(vNodes.get(2), vNodes.get(5));
		// initaledGraph.addEdge(vNodes.get(3), vNodes.get(5));
		// initaledGraph.addEdge(vNodes.get(4), vNodes.get(6));
		// initaledGraph.addEdge(vNodes.get(5), vNodes.get(6));

		// Testing Graph 2 <V,E> = <7, 10>
		graph.addEdge(vNodes.get(0), vNodes.get(1));
		graph.addEdge(vNodes.get(0), vNodes.get(3));
		graph.addEdge(vNodes.get(0), vNodes.get(4));
		graph.addEdge(vNodes.get(1), vNodes.get(4));
		graph.addEdge(vNodes.get(2), vNodes.get(5));
		graph.addEdge(vNodes.get(2), vNodes.get(6));
		graph.addEdge(vNodes.get(3), vNodes.get(4));
		graph.addEdge(vNodes.get(3), vNodes.get(5));
		graph.addEdge(vNodes.get(4), vNodes.get(6));
		graph.addEdge(vNodes.get(5), vNodes.get(6));
		
		// Testing a counter example <3, 3>
//		graph.addEdge(vNodes.get(1), vNodes.get(0));
//		graph.addEdge(vNodes.get(2), vNodes.get(1));

		return graph;
	}
	
	public static List<Node> copyVertexList(List<Node> nodes) {
		List<Node> newNodes = new ArrayList<Node>();
		for (Node n : nodes) {
			newNodes.add(new Node(n));
		}
		return newNodes;
	}
}
