package Graph;

import java.util.List;

/**
 * 
 * @author zhangy10 671205
 *
 *         Sep 1, 2015
 *
 *         Graph.java
 */
public interface Graph {
    public void addEdge(Node from, Node to);

    public List<Node> getAdjacency(Node v, List<Node> nodes);

    public void printGraph();

    public int getSize();

    public List<Node> getVertexs();
}
