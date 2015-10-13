package Graph;

public class MainDriver {

    public static void main(String[] args) {
        int size = 7;
        // Test BFS
        BreadthSearch graphBFS = new BreadthSearch(size);
        graphBFS.getGraph().printGraph();
        graphBFS.printDegree();
        graphBFS.BFS();

        // Test TopologicalSort
        TopologicalSort graphTSort = new TopologicalSort(size);
        graphTSort.printSortedList(graphTSort.topologicalSort());
        graphTSort.removeSourceSort();

        // Test DFS
        DepthFirstSearch graphDFS = new DepthFirstSearch(size);
        graphDFS.DFS();
    }

}
