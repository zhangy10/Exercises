package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 * 
 * @author zhangy10 671205
 *
 *         Aug 29, 2015
 *
 *         GraphTravel.java
 * 
 *         Implement by using Adjacency Matrix
 */
public class BreadthSearch extends GraphTravel {
	// for breadthSearch
	private Queue<Node> queue;

	public BreadthSearch(int size) {
		super(size);
		queue = new LinkedList<Node>();
	}

	public static void main(String[] args) {
		BreadthSearch graphSearch = new BreadthSearch(7);
		List<Node> vNodes = graphSearch.getVertexs();
		Graph graph = graphSearch.getGraph();

		// Testing Graph 1 <V,E> = <7, 9>
//		 graph.addEdge(vNodes.get(0), vNodes.get(1));
//		 graph.addEdge(vNodes.get(0), vNodes.get(2));
//		 graph.addEdge(vNodes.get(0), vNodes.get(3));
//		 graph.addEdge(vNodes.get(1), vNodes.get(4));
//		 graph.addEdge(vNodes.get(2), vNodes.get(4));
//		 graph.addEdge(vNodes.get(2), vNodes.get(5));
//		 graph.addEdge(vNodes.get(3), vNodes.get(5));
//		 graph.addEdge(vNodes.get(4), vNodes.get(6));
//		 graph.addEdge(vNodes.get(5), vNodes.get(6));

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
		
		graph.printGraph();

		graphSearch.BFS();
		for (int i = 0; i < vNodes.size(); i++) {
			Node v = vNodes.get(i);
			System.out.println("Vertex :[" + (v.vaule + 1) + "] Indegree : "
					+ v.inDegree + " Outdegree : " + v.outDegree);
		}
//		System.out.printf("%nThe complexity of this algorithm is : %d%n",
//				graphSearch.getComplexity());
		
		System.out.println();
		List<Node> sortedList = graphSearch.topologicalSort();
		System.out.print("The topological sort sequence is : ");
		for (Node v : sortedList) {
			System.out.print((v.vaule + 1) + " ");
		}
		System.out.println();
	}

	/**
	 * Breadth-First Search
	 * 
	 * Calculating the Indegree and Outdegree of each node
	 */
	public void BFS() {
		System.out.println();
		System.out.print("BFS: < The visited sequence :");
		for (int i = 0; i < graph.getSizeOfVertex(); i++) {
			complexity++;
			Node v = vertexs.get(i);
			if (v.state == GraphState.NON_VISITED) {
				visitedNode(v);
				queue.add(v);
				while (!queue.isEmpty()) {
					Node topNode = queue.poll();
					List<Node> adjacentNodes = graph.getAdjacency(topNode);
					// Calculate out degree here
					topNode.outDegree = adjacentNodes.size();
					for (int j = 0; j < adjacentNodes.size(); j++) {
						complexity++;
						Node adjNode = adjacentNodes.get(j);
						// Calculate in degree here
						adjNode.inDegree++;
						if (adjNode.state == GraphState.NON_VISITED) {
							visitedNode(adjNode);
							queue.add(adjNode);
						}
					}
				}
			}
		}
		System.out.println(">");
		System.out.println();
	}
	
	/**
	 * By using the idea of removing each source repeatedly
	 * 
	 */
	public List<Node> topologicalSort() {
		List<Node> deletedList = new ArrayList<Node>();
		int i = 0;
		while (deletedList.size() != vertexs.size()) {
			Node v = vertexs.get(i);
			if (!deletedList.contains(v) && v.inDegree == 0) {
				List<Node> adjacentNodes = graph.getAdjacency(v);
				for (Node adjacentNode : adjacentNodes) {
					adjacentNode.inDegree--;
				}
				deletedList.add(v);
			}
			i++;
			i %= vertexs.size();
		}
		return deletedList;
	}
}
