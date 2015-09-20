package Graph;

import java.util.List;
import java.util.Stack;

/**
 * 
 * @author zhangy10 671205
 *
 *         Sep 1, 2015
 *
 *         DepthFirstSearch.java
 */
public class DepthFirstSearch extends GraphTravel{
	private List<Node> vertexes;
	
	public DepthFirstSearch(int size) {
		super(size);
		vertexes = graph.getVertexs();
	}

	public void DFS() {
		System.out.print("DFS: < The visited sequence :");
		for (Node v : vertexes) {
			if (v.state == GraphState.NON_VISITED) {
				DFSExplore(v);
			}
		}
		System.out.println(">");
		System.out.println();
	}
	
	private void DFSExplore(Node v) {
		visitedNode(v);
		for (Node node : getGraph().getAdjacency(v, vertexes)) {
			if (node.state == GraphState.NON_VISITED) {
				DFSExplore(node);
			}
		}
	}
	
	public void DFS(Stack<Node> stack) {
		if (stack == null) {
			return;
		}
		
	}
}
