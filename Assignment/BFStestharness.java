public class BFStestharness {
    public static void main(String[] args) {
        // Create a graph
        Graph graph = new Graph(6, 7);

        Graph.Vertex v1 = new Graph.Vertex("A");
        Graph.Vertex v2 = new Graph.Vertex("B");
        Graph.Vertex v3 = new Graph.Vertex("C");
        Graph.Vertex v4 = new Graph.Vertex("D");
        Graph.Vertex v5 = new Graph.Vertex("E");
        Graph.Vertex v6 = new Graph.Vertex("F");

        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);
        graph.addVertex(v4);
        graph.addVertex(v5);
        graph.addVertex(v6);

        graph.addEdge(v1, v2, 1.0);
        graph.addEdge(v1, v3, 1.0);
        graph.addEdge(v2, v4, 1.0);
        graph.addEdge(v2, v5, 1.0);
        graph.addEdge(v3, v4, 1.0);
        graph.addEdge(v4, v5, 1.0);
        graph.addEdge(v4, v6, 1.0);

        // Perform BFS starting from vertex v1
        System.out.println("BFS traversal:");
        graph.BFS(v1);

        System.out.println();

        // Perform DFS starting from vertex v1
        System.out.println("DFS traversal:");
        graph.DFS(v1);
    }
}
