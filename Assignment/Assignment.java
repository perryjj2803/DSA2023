import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Assignment {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader("location.txt"));

        String[] line1 = reader.readLine().split(" ");
        int numVertices = Integer.parseInt(line1[0]);
        int numEdges = Integer.parseInt(line1[1]);

        Graph graph = new Graph();

        // Create vertices
        DSALinkedList vertices = new DSALinkedList();
        for (int i = 0; i < numVertices; i++) {
            String label = Character.toString((char) ('A' + i));
            Graph.Vertex vertex = new Graph.Vertex(label);
            vertices.insertLast(vertex);
        }

        // Add vertices to the graph
        for (Object obj : vertices) {
            Graph.Vertex vertex = (Graph.Vertex)obj;
            graph.addVertex(vertex);
        }

        // Create edges
        for (int i = 0; i < numEdges; i++) {
            String[] line = reader.readLine().split(" ");
            String startLabel = line[0];
            String endLabel = line[1];
            double weight = Double.parseDouble(line[2]);

            Graph.Vertex start = null;
            Graph.Vertex end = null;

            // Find the corresponding vertices from the created vertices array
            for (Object obj : vertices) {
                Graph.Vertex vertex = (Graph.Vertex)obj;
                if (vertex.getLabel().equals(startLabel)) {
                    start = vertex;
                } else if (vertex.getLabel().equals(endLabel)) {
                    end = vertex;
                }
            }

            // Add the edges to the graph
            graph.addEdge(start, end, weight);
        }

        reader.close();

        // Read UAV data from UAVdata.txt
        BufferedReader uavReader = new BufferedReader(new FileReader("UAVdata.txt"));

        for (int i = 0; i < numVertices; i++) {
            String[] line = uavReader.readLine().split(" ");
            double temp = Double.parseDouble(line[1]);
            double humidity = Double.parseDouble(line[2]);
            double wind = Double.parseDouble(line[3]);

            Graph.Vertex vertex = (Graph.Vertex)vertices.removeFirst();
            vertex.setTemp(temp);
            vertex.setHumidity(humidity);
            vertex.setWind(wind);
            vertices.insertLast(vertex);
        }

        uavReader.close();

        // Create an instance of Menu class and pass the graph to it
        Menu menu = new Menu(graph);
        menu.showMenu();
    }
}
