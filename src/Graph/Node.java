package Graph;

public class Node {
	int vaule;
	int inDegree;
	int outDegree;
	GraphState state = GraphState.NON_VISITED;

	public Node(int vaule) {
		this.vaule = vaule;
	}
	
	public Node(Node n) {
		this.vaule = n.vaule;
		this.inDegree = n.inDegree;
		this.outDegree = n.outDegree;
		this.state = n.state;
	}
}