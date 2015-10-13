package Graph;

import java.util.LinkedList;
import java.util.List;
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
public class BreadthSearch extends GraphTravel {
    // for breadthSearch
    private Queue<Node> queue;

    public BreadthSearch(int size) {
        super(size);
        queue = new LinkedList<Node>();
    }

    /**
     * Breadth-First Search
     * 
     * Calculating the Indegree and Outdegree of each node
     */
    public void BFS() {
        System.out.print("BFS: < The visited sequence :");
        List<Node> vertexs = graph.getVertexs();
        for (int i = 0; i < graph.getSize(); i++) {
            Node v = vertexs.get(i);
            if (v.state == GraphState.NON_VISITED) {
                visitedNode(v);
                queue.add(v);
                while (!queue.isEmpty()) {
                    Node topNode = queue.poll();
                    List<Node> adjacentNodes = graph.getAdjacency(topNode,
                            vertexs);
                    for (int j = 0; j < adjacentNodes.size(); j++) {
                        Node adjNode = adjacentNodes.get(j);
                        if (adjNode.state == GraphState.NON_VISITED) {
                            visitedNode(adjNode);
                            queue.add(adjNode);
                        }
                    }
                }
            }
        }
        System.out.println(">");
    }
}
