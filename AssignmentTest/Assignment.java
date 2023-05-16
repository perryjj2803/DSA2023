import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Assignment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("location.txt"));

        String[] line1 = reader.readLine().split(" ");
        int numVertices = Integer.parseInt(line1[0]);
        int numEdges = Integer.parseInt(line1[1]);

        Map<String, Graph.Vertex> vertices = new HashMap<>();

        // Create vertices
        for (int i = 0; i < numVertices; i++) {
            String label = Character.toString((char) ('A' + i));
            Graph.Vertex vertex = new Graph.Vertex(label);
            vertices.put(label, vertex);
        }

        // Create graph
        Graph graph = new Graph();

        // Add vertices to the graph
        for (Graph.Vertex vertex : vertices.values()) {
            graph.addVertex(vertex);
        }

        // Add edges to the graph
        for (int i = 0; i < numEdges; i++) {
            String[] line = reader.readLine().split(" ");
            String startLabel = line[0];
            String endLabel = line[1];
            double weight = Double.parseDouble(line[2]);

            Graph.Vertex start = vertices.get(startLabel);
            Graph.Vertex end = vertices.get(endLabel);

            graph.addEdge(start, end, weight);
        }

        reader.close();

        // Print the graph
        for (Graph.Vertex vertex : vertices.values()) {
            List<Graph.Edge> edges = graph.getEdges(vertex);

            System.out.print(vertex + " -> ");

            for (Graph.Edge edge : edges) {
                System.out.print(edge.getEnd() + "(" + edge.getWeight() + ") ");
            }

            System.out.println();
        }
    }
}