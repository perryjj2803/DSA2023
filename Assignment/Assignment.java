import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public class Assignment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("location.txt"));

        String[] line1 = reader.readLine().split(" ");
        int numVertices = Integer.parseInt(line1[0]);
        int numEdges = Integer.parseInt(line1[1]);

        Graph graph = new Graph();

        // Create vertices
        for (int i = 0; i < numVertices; i++) {
            String label = Character.toString((char) ('A' + i));
            Graph.Vertex vertex = new Graph.Vertex(label);
            graph.addVertex(vertex);
        }

        // Create edges
        for (int i = 0; i < numEdges; i++) {
            String[] line = reader.readLine().split(" ");
            String startLabel = line[0];
            String endLabel = line[1];
            double weight = Double.parseDouble(line[2]);

            Graph.Vertex start = new Graph.Vertex(startLabel);
            Graph.Vertex end = new Graph.Vertex(endLabel);

            // Add the vertices to the graph before creating edges
            graph.addVertex(start);
            graph.addVertex(end);

            graph.addEdge(start, end, weight);
        }

        reader.close();

        // Print the graph
        for (Graph.Vertex vertex : graph.getVertices()) {
            List<Graph.Edge> edges = graph.getEdges(vertex);

            System.out.print(vertex + " -> ");

            for (Graph.Edge edge : edges) {
                System.out.print(edge.getEnd() + "(" + edge.getWeight() + ") ");
            }

            System.out.println();
        }
    }
}
