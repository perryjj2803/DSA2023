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

        Graph graph = new Graph(numVertices, numEdges);

        // Create vertices
        Graph.Vertex[] vertices = new Graph.Vertex[numVertices];
        for (int i = 0; i < numVertices; i++) {
            String label = Character.toString((char) ('A' + i));
            Graph.Vertex vertex = new Graph.Vertex(label);
            vertices[i] = vertex;
        }

        // Add vertices to the graph
        for (Graph.Vertex vertex : vertices) {
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
            for (Graph.Vertex vertex : vertices) {
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

    vertices[i].setTemp(temp);
    vertices[i].setHumidity(humidity);
    vertices[i].setWind(wind);
}

uavReader.close();


        // Print the graph for task 1
for (Graph.Vertex vertex : graph.getVertices()) {
    List<Graph.Edge> edges = graph.getEdges(vertex);

    System.out.print(vertex + " -> ");

    for (Graph.Edge edge : edges) {
        // If the current vertex is the start vertex, print the end vertex and weight
        if (edge.getStart().equals(vertex)) {
            System.out.print(edge.getEnd() + "(" + edge.getWeight() + ") ");
        } 
        // If the current vertex is the end vertex, print the start vertex and weight
        else {
            System.out.print(edge.getStart() + "(" + edge.getWeight() + ") ");
        }
    }

    System.out.println();
}

        // Print the graph for task 2
        // REPORT: having an issue where the end vertex is equal to the start

            for (Graph.Vertex vertex : graph.getVertices()) {
                List<Graph.Edge> edges = graph.getEdges(vertex);

                System.out.print(vertex.getLabel() + " (Temp: " + vertex.getTemp() +
                    ", Humidity: " + vertex.getHumidity() +
                    ", Wind: " + vertex.getWind() + ") -> ");

                for (Graph.Edge edge : edges) {
                    System.out.print(edge.getEnd().getLabel() + "(" + edge.getWeight() + ") ");
                }

            System.out.println();
        }     
    }
}
