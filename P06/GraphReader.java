import java.io.*;
import java.util.*;
public class GraphReader {

    public static DSAGraph readGraph(String fileName) {
        DSAGraph graph = new DSAGraph();

        try {
            BufferedReader reader = new BufferedReader(new FileReader(fileName));
            String line = reader.readLine();
            while (line != null) {
                String[] vertices = line.split(" ");
                if (vertices.length == 2) {
                    String vertex1 = vertices[0].trim();
                    String vertex2 = vertices[1].trim();
                    if (!graph.hasNode(vertex1)) {
                        graph.addNode(vertex1, null);
                    }
                    if (!graph.hasNode(vertex2)) {
                        graph.addNode(vertex2, null);
                    }
                    graph.addEdge(vertex1, vertex2);
                }
                line = reader.readLine();
            }
            reader.close();
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }

        return graph;
    }
}