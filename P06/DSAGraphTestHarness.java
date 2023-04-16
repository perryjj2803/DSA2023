public class DSAGraphTestHarness
{
    public static void main(String[] args)
    {
        // Create an empty graph
        DSAGraph graph = new DSAGraph();

        // Test addVertex and getVertexCount
        graph.addVertex("A", 1);
        graph.addVertex("B", 2);
        graph.addVertex("C", 3);
        graph.addVertex("D", 4);
        graph.addVertex("E", 5);

        System.out.println("Vertex count: " + graph.getVertexCount()); // Should be 5

        // Test addEdge and getEdgeCount
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");

        System.out.println("Edge count: " + graph.getEdgeCount()); // Should be 6

        // Test hasVertex
        System.out.println("Has vertex A? " + graph.hasVertex("A")); // Should be true
        System.out.println("Has vertex F? " + graph.hasVertex("F")); // Should be false

        // Test getAdjacent
        System.out.println("Adjacent to A: " + graph.getAdjacent("A")); // Should be B, C, D

        // Test isAdjacent
        System.out.println("A and B adjacent? " + graph.isAdjacent("A", "B")); // Should be true
        System.out.println("A and E adjacent? " + graph.isAdjacent("A", "E")); // Should be false

        // Test displayAsList
        System.out.println("Graph display as list:");
        graph.displayAsList();

        // Test displayAsMatrix
        System.out.println("Graph display as matrix:");
        graph.displayAsMatrix();

        // Test visited methods
        DSAGraph.DSAGraphVertex vertex = graph.getVertex("A");
        System.out.println("A visited? " + vertex.getVisited()); // Should be false
        vertex.setVisited();
        System.out.println("A visited? " + vertex.getVisited()); // Should be true
        vertex.clearVisited();
        System.out.println("A visited? " + vertex.getVisited()); // Should be false
    }
}
