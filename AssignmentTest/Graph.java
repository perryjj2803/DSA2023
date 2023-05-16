import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {
    private Vertex[] vertices;
    private Edge[] edges;
    private int vertexCount;
    private int edgeCount;

    public Graph(int numVertices, int numEdges) {
        vertices = new Vertex[numVertices];
        edges = new Edge[numEdges];
        vertexCount = 0;
        edgeCount = 0;
    }

    public void addVertex(Vertex vertex) {
        if (!containsVertex(vertex)) {
            vertices[vertexCount++] = vertex;
        }
    }

    public void addEdge(Vertex start, Vertex end, double weight) {
        if (!hasEdge(start, end)) {
            Edge edge = new Edge(start, end, weight);
            edges[edgeCount++] = edge;
        }
    }

    public boolean hasEdge(Vertex start, Vertex end) {
        for (Edge edge : edges) {
            if (edge != null && edge.getStart() != null && edge.getEnd() != null &&
                    edge.getStart().equals(start) && edge.getEnd().equals(end)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsVertex(Vertex vertex) {
        for (int i = 0; i < vertexCount; i++) {
            if (vertices[i].equals(vertex)) {
                return true;
            }
        }
        return false;
    }

    public List<Edge> getEdges(Vertex vertex) {
        Edge[] vertexEdges = new Edge[edgeCount];
        int count = 0;
        for (int i = 0; i < edgeCount; i++) {
            Edge edge = edges[i];
            if (edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)) {
                vertexEdges[count++] = edge;
            }
        }
        return Arrays.asList(Arrays.copyOf(vertexEdges, count));
    }

    public List<Vertex> getVertices() {
        return Arrays.asList(Arrays.copyOf(vertices, vertexCount));
    }

    public static class Vertex {
        private String label;

        public Vertex(String label) {
            this.label = label;
        }

        public String getLabel() {
            return label;
        }

        public String toString() {
            return label;
        }

        public boolean equals(Object o) {
            if (o instanceof Vertex) {
                Vertex other = (Vertex) o;
                return label.equals(other.label);
            }
            return false;
        }

        public int hashCode() {
            return label.hashCode();
        }
    }

    public static class Edge {
        private Vertex start;
        private Vertex end;
        private double weight;

        public Edge(Vertex start, Vertex end, double weight) {
            this.start = start;
            this.end = end;
            this.weight = weight;
        }

        public Vertex getStart() {
            return start;
        }

        public Vertex getEnd() {
            return end;
        }

        public double getWeight() {
            return weight;
        }

        public boolean equals(Object o) {
            if (o instanceof Edge) {
                Edge other = (Edge) o;
                return start.equals(other.start) && end.equals(other.end) && weight == other.weight;
            }
            return false;
        }
    }
}
