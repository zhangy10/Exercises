package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class TopologicalSort extends GraphTravel{
	private Queue<Node> queue; 
	
	public TopologicalSort(int size) {
		super(size);
		queue = new LinkedList<Node>();
	}
	
	/**
	 * By using the idea of removing each source repeatedly
	 * 
	 */
	public List<Node> topologicalSort() {
		// O(n^2)
		List<Node> deletedList = new ArrayList<Node>();
		List<Node> vertexs = graph.getVertexs();
		int i = 0;
		while (deletedList.size() != graph.getSize()) {
			Node v = vertexs.get(i);
			if (!deletedList.contains(v) && v.inDegree == 0) {
				List<Node> adjacentNodes = graph.getAdjacency(v, vertexs);
				for (Node adjacentNode : adjacentNodes) {
					adjacentNode.inDegree--;
				}
				deletedList.add(v);
			}
			i++;
			i %= graph.getSize();
		}
		return deletedList;
	}
	
	public void removeSourceSort() {
		System.out.print("The topological sort sequence is : ");
		// O(V + E) BFS
		List<Node> vertexs = graph.getVertexs();
		for (Node node : vertexs) {
			if (node.state == GraphState.NON_VISITED && node.inDegree == 0) {
				visitedNode(node);
				queue.add(node);
				while(!queue.isEmpty()) {
					List<Node> adjacentNodes = graph.getAdjacency(queue.poll(), vertexs);
					for (Node adjNode : adjacentNodes) {
						adjNode.inDegree--;
						if (adjNode.state == GraphState.NON_VISITED && adjNode.inDegree == 0) {
							visitedNode(adjNode);
							queue.add(adjNode);
						}
					}
				}
			}
		}
		System.out.println();
	}
	
	public void printSortedList(List<Node> sortedList) {
		System.out.print("The topological sort sequence is : ");
		for (Node v : sortedList) {
			System.out.print((v.vaule + 1) + " ");
		}
		System.out.println();
	}
}
