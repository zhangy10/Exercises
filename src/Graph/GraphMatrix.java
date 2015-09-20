package Graph;

import java.util.ArrayList;
import java.util.List;

import Programming.Matrix;

/**
 * 
 * @author zhangy10 671205
 *
 *         Sep 1, 2015
 *
 *         GraphMatrix.java
 */
public class GraphMatrix implements Graph {
	private int[][] graph;
	private List<Node> vertexs;
	private Matrix matrix;

	public List<Node> getVertexs() {
		return BuildGraph.copyVertexList(vertexs);
	}

	public int getSize() {
		return vertexs.size();
	}

	public GraphMatrix(int size) {
		graph = new int[size][size];
		vertexs = new ArrayList<Node>();
		for (int i = 0; i < size; i++) {
			vertexs.add(new Node(i));
		}
		matrix = new Matrix(size + "");
	}
	
	@Override
	public void addEdge(Node from, Node to) {
		graph[from.vaule][to.vaule]++;
		// Here can calculate each node's indegree and outdegree
		for (Node node : vertexs) {
			if (node.vaule == from.vaule) node.outDegree++;
			if (node.vaule == to.vaule) node.inDegree++;
		}
	}

	@Override
	public List<Node> getAdjacency(Node v, List<Node> nodes) {
		ArrayList<Node> adjacentNodes = new ArrayList<Node>();
		for (int i = 0; i < getSize(); i++) {
			if (graph[v.vaule][i] != 0) {
				adjacentNodes.add(nodes.get(i));
			}
		}
		return adjacentNodes;
	}

	@Override
	public void printGraph() {
		System.out.println("The current graph matrix is:");
		matrix.newLine(true);
		for (int i = 0; i < getSize() + 1; i++) {
			for (int j = 0; j < getSize() + 1; j++) {
				matrix.printMartix(i, j,
						i > 0 && j > 0 ? graph[i - 1][j - 1] + "" : "");
			}
			if (i == getSize()) {
				matrix.newLine(true);
			}
			else {
				matrix.newLine();
			}
		}
	}
}
