public class DSAGraphTestHarness
{
    public static void main(String[] args)
    {
        // Create an empty graph
        DSAGraph graph = new DSAGraph();

        // Test addNode and getnodeCount
        graph.addNode("A", 1);
        graph.addNode("B", 2);
        graph.addNode("C", 3);
        graph.addNode("D", 4);
        graph.addNode("E", 5);

        System.out.println("node count: " + graph.getNodeCount()); // Should be 5

        // Test addEdge and getEdgeCount
        graph.addEdge("A", "B");
        graph.addEdge("A", "C");
        graph.addEdge("A", "D");
        graph.addEdge("B", "C");
        graph.addEdge("C", "D");
        graph.addEdge("C", "E");

        System.out.println("Edge count: " + graph.getEdgeCount()); // Should be 6

        // Test hasNode
        System.out.println("Has node A? " + graph.hasNode("A")); // Should be true
        System.out.println("Has node F? " + graph.hasNode("F")); // Should be false

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
        DSAGraph.DSAGraphNode node = graph.getNode("A");
        System.out.println("A visited? " + node.getVisited()); // Should be false
        node.setVisited();
        System.out.println("A visited? " + node.getVisited()); // Should be true
        node.clearVisited();
        System.out.println("A visited? " + node.getVisited()); // Should be false
    }
}
