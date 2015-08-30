import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

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
public class GraphTravel {
	private GraphMatrix graph;
	private Queue<Node> queue;
	private Node[] vertexs;
	int count = 0;

	public GraphMatrix getGraph() {
		return graph;
	}

	public Node[] getVertexs() {
		return vertexs;
	}

	public GraphTravel(int size) {
		graph = new GraphMatrix(size);
		vertexs = graph.getVertexs();
		queue = new LinkedList<Node>();
	}

	public static void main(String[] args) {
		GraphTravel graphSearch = new GraphTravel(7);
		Node[] vNodes = graphSearch.getVertexs();
		GraphMatrix graph = graphSearch.getGraph();

		// Testing Graph 1 <V,E> = <7, 9>
		// graph.addEdge(vNodes[0], vNodes[1]);
		// graph.addEdge(vNodes[0], vNodes[2]);
		// graph.addEdge(vNodes[0], vNodes[3]);
		// graph.addEdge(vNodes[1], vNodes[4]);
		// graph.addEdge(vNodes[2], vNodes[4]);
		// graph.addEdge(vNodes[2], vNodes[5]);
		// graph.addEdge(vNodes[3], vNodes[5]);
		// graph.addEdge(vNodes[4], vNodes[6]);
		// graph.addEdge(vNodes[5], vNodes[6]);

		// Testing Graph 2 <V,E> = <7, 10>
		graph.addEdge(vNodes[0], vNodes[1]);
		graph.addEdge(vNodes[0], vNodes[3]);
		graph.addEdge(vNodes[0], vNodes[4]);
		graph.addEdge(vNodes[1], vNodes[4]);
		graph.addEdge(vNodes[2], vNodes[5]);
		graph.addEdge(vNodes[2], vNodes[6]);
		graph.addEdge(vNodes[3], vNodes[4]);
		graph.addEdge(vNodes[3], vNodes[5]);
		graph.addEdge(vNodes[4], vNodes[6]);
		graph.addEdge(vNodes[5], vNodes[6]);

		graph.printGraph();
		
		graphSearch.BFS();
		for (int i = 0; i < vNodes.length; i++) {
			Node v = vNodes[i];
			System.out.println("Vertex :" + (v.vaule + 1) + " Indegree :"
					+ v.inDegree + " Outdegree :" + v.outDegree);
		}
		System.out.printf("%nThe complexity of BFS is :%d%n", graphSearch.count);
		
		graphSearch.resetGraph();
		graphSearch.DFS();
	}
	
	public void resetGraph() {
		this.count = 0;
		for (int i = 0; i < vertexs.length; i++) {
			vertexs[i].state = GraphState.NON_VISITED;
		}
	}

	/**
	 * Depth-First Search
	 * 
	 */
	public void DFS() {

	}

	/**
	 * Breadth-First Search
	 * 
	 * Calculating the Indegree and Outdegree of each node
	 */
	public void BFS() {
		System.out.println();
		System.out.print("BFS: < The visited sequence :");
		for (int i = 0; i < graph.sizeOfVertex; i++) {
			count++;
			Node v = vertexs[i];
			if (v.state == GraphState.NON_VISITED) {
				visitedNode(v);
				queue.add(v);
				while (!queue.isEmpty()) {
					Node topNode = queue.poll();
					Node[] adjacentNodes = graph.getAdjacency(topNode);
					// Calculate out degree here
					topNode.outDegree = adjacentNodes.length;
					for (int j = 0; j < adjacentNodes.length; j++) {
						count++;
						Node adjNode = adjacentNodes[j];
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

	public void visitedNode(Node n) {
		n.state = GraphState.VISITED;
		System.out.print((n.vaule + 1) + " ");
	}

}

class Node {
	int vaule;
	int inDegree;
	int outDegree;
	GraphState state = GraphState.NON_VISITED;

	public Node(int vaule) {
		this.vaule = vaule;
	}
}

class GraphMatrix {
	int[][] graph;
	int sizeOfVertex;
	Node[] vertexs;
	private Matrix matrix;

	public Node[] getVertexs() {
		return vertexs;
	}

	public GraphMatrix(int size) {
		this.sizeOfVertex = size;
		graph = new int[this.sizeOfVertex][this.sizeOfVertex];
		vertexs = new Node[this.sizeOfVertex];
		for (int i = 0; i < this.sizeOfVertex; i++) {
			vertexs[i] = new Node(i);
		}
		matrix = new Matrix(size + "");
	}

	public void addEdge(Node from, Node to) {
		graph[from.vaule][to.vaule]++;
	}

	public Node[] getAdjacency(Node v) {
		ArrayList<Node> adjacentNodes = new ArrayList<Node>();
		for (int j = 0; j < this.sizeOfVertex; j++) {
			if (graph[v.vaule][j] != 0) {
				adjacentNodes.add(vertexs[j]);
			}
		}
		Node[] results = new Node[adjacentNodes.size()];
		for (int i = 0; i < results.length; i++) {
			results[i] = adjacentNodes.get(i);
		}
		return results;
	}

	public void printGraph() {
		for (int i = 0; i < this.sizeOfVertex + 1; i++) {
			for (int j = 0; j < this.sizeOfVertex + 1; j++) {
				matrix.printMartix(i, j,
						i > 0 && j > 0 ? graph[i - 1][j - 1] + "" : "");
			}
			if (i != this.sizeOfVertex) {
				matrix.newLine();
			}
		}
	}
}

enum GraphState {
	VISITED, NON_VISITED,
}
