public class UnitTestGraph {
    public static void main(String[] args) {
        Graph graph = new Graph();

        // Create vertices
        Graph.Vertex v1 = new Graph.Vertex("A");
        Graph.Vertex v2 = new Graph.Vertex("B");
        Graph.Vertex v3 = new Graph.Vertex("C");
        Graph.Vertex v4 = new Graph.Vertex("D");

        // Add vertices to the graph
        graph.addVertex(v1);
        graph.addVertex(v2);
        graph.addVertex(v3);

        // Test containsVertex method
        System.out.println("Does graph contain vertex v1? " + graph.containsVertex(v1));
        System.out.println("Does graph contain vertex v2? " + graph.containsVertex(v2));
        System.out.println("Does graph contain vertex v3? " + graph.containsVertex(v3));
        System.out.println("Does graph contain vertex v4? " + graph.containsVertex(v4));

        // Test addEdge and hasEdge methods
        graph.addEdge(v1, v2, 2.0);
        graph.addEdge(v1, v3, 1.5);
        System.out.println("Does graph have an edge between v1 and v2? " + graph.hasEdge(v1, v2));
        System.out.println("Does graph have an edge between v1 and v3? " + graph.hasEdge(v1, v3));
        System.out.println("Does graph have an edge between v2 and v3? " + graph.hasEdge(v2, v3));

        // Test getEdges method
        DSALinkedList edges1 = graph.getEdges(v1);
        System.out.println("Number of edges for vertex v1: " + countEdges(edges1));

        // Test removeEdge method
        if (!edges1.isEmpty()) {
            Graph.Edge edge = (Graph.Edge) edges1.removeFirst();
            graph.removeEdge(edge);
        }
        System.out.println("Does graph have an edge between v1 and v2 after removal? " + graph.hasEdge(v1, v2));
        edges1 = graph.getEdges(v1);
        System.out.println("Number of edges for vertex v1 after removal: " + countEdges(edges1));

        // Test removeVertex method
        graph.removeVertex(v1);
        System.out.println("Does graph contain vertex v1 after removal? " + graph.containsVertex(v1));
        System.out.println("Number of edges for vertex v2 after vertex removal: " + countEdges(graph.getEdges(v2)));
    }

    private static int countEdges(DSALinkedList edges) {
        int count = 0;
        DSALinkedList tempEdges = new DSALinkedList();
        while (!edges.isEmpty()) {
            tempEdges.insertLast(edges.removeFirst());
            count++;
        }
        edges = tempEdges;
        return count;
    }
}
