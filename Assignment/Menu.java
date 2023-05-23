import java.util.*;
import java.util.Scanner;

public class Menu {
    private Graph graph;

    public Menu(Graph graph) {
        this.graph = graph;
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n------ MENU ------");
            System.out.println("1. Insert a location");
            System.out.println("2. Delete a location");
            System.out.println("3. Search for a location");
            System.out.println("4. Print the graph");
            System.out.println("5. Exit");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume the newline character

            switch (choice) {
                case 1:
                    insertLocation();
                    break;
                case 2:
                    deleteLocation();
                    break;
                case 3:
                    searchLocation();
                    break;
                case 4:
                    printGraph();
                    break;
                case 5:
                    exit = true;
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    private void insertLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the label of the location: ");
        String label = scanner.nextLine();
        System.out.print("Enter the temperature: ");
        double temperature = scanner.nextDouble();
        System.out.print("Enter the humidity: ");
        double humidity = scanner.nextDouble();
        System.out.print("Enter the wind speed: ");
        double windSpeed = scanner.nextDouble();
        scanner.nextLine(); // Consume the newline character

        Graph.Vertex vertex = new Graph.Vertex(label);
        vertex.setTemp(temperature);
        vertex.setHumidity(humidity);
        vertex.setWind(windSpeed);

        graph.addVertex(vertex);
        System.out.println("Location inserted successfully.");
    }

    private void deleteLocation() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the label of the location to delete: ");
        String label = scanner.nextLine();

        Graph.Vertex vertex = new Graph.Vertex(label);
        graph.removeVertex(vertex);
        System.out.println("Location deleted successfully.");
    }

    private void searchLocation() {
     Scanner scanner = new Scanner(System.in);
    System.out.print("Enter the label of the location to search: ");
    String label = scanner.nextLine();

    Graph.Vertex vertex = null;
    DSALinkedList vertices = graph.getVertices();
    for (Object obj : vertices) {
        Graph.Vertex v = (Graph.Vertex) obj;
        if (v.getLabel().equals(label)) {
            vertex = v;
            break;
        }
    }

    if (vertex != null) {
        System.out.println("Location found:");
        System.out.println("Label: " + vertex.getLabel());
        System.out.println("Temperature: " + vertex.getTemp());
        System.out.println("Humidity: " + vertex.getHumidity());
        System.out.println("Wind speed: " + vertex.getWind());
    } else {
        System.out.println("Location not found.");
    }
    }

    private void printGraph() {
        DSALinkedList graphVertices = graph.getVertices();
        for (Object obj : graphVertices) {
            Graph.Vertex vertex = (Graph.Vertex) obj;
            DSALinkedList edges = graph.getEdges(vertex);

            System.out.print(vertex + " -> ");

            for (Object edgeObj : edges) {
                Graph.Edge edge = (Graph.Edge) edgeObj;
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
    }
}
