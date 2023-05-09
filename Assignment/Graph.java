import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Graph {
    private List<Vertex> vertices;
    private List<Edge> edges;

    public Graph() {
        vertices = new ArrayList<>();
        edges = new ArrayList<>();
    }

    public void addVertex(Vertex vertex) {
        if (!vertices.contains(vertex)) {
            vertices.add(vertex);
        }
    }

    public void addEdge(Vertex start, Vertex end, double weight) {
        if (!hasEdge(start, end)) {
            Edge edge = new Edge(start, end, weight);
            edges.add(edge);
        }
    }

    public boolean hasEdge(Vertex start, Vertex end) {
        for (Edge edge : edges) {
            if (edge.getStart().equals(start) && edge.getEnd().equals(end)) {
                return true;
            }
        }
        return false;
    }

    public List<Edge> getEdges(Vertex vertex) {
        List<Edge> vertexEdges = new ArrayList<>();
        for (Edge edge : edges) {
            if (edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)) {
                vertexEdges.add(edge);
            }
        }
        return vertexEdges;
    }

    public List<Vertex> getVertices() {
        return vertices;
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

        public int hashCode() {
            return start.hashCode() + end.hashCode() + Double.hashCode(weight);
        }
    }
}
