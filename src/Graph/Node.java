package Graph;

public class Node {
	int vaule;
	int inDegree;
	int outDegree;
	GraphState state = GraphState.NON_VISITED;

	public Node(int vaule) {
		this.vaule = vaule;
	}
}