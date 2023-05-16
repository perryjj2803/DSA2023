import java.util.*;

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

    public int getIndex(Vertex vertex) {
    for (int i = 0; i < vertexCount; i++) {
        if (vertices[i].equals(vertex)) {
            return i;
        }
    }
    return -1;
}

private Vertex getNeighbor(Edge edge, Vertex vertex) {
    if (edge.getStart().equals(vertex)) {
        return edge.getEnd();
    } else {
        return edge.getStart();
    }
}

   public void BFS(Vertex start) {
    boolean[] visited = new boolean[vertices.length];
    DSAQueue queue = new DSAQueue();

    visited[getIndex(start)] = true;
    queue.enqueue(start);

    while (!queue.isEmpty()) {
        Vertex currentVertex = (Vertex) queue.dequeue();
        System.out.print(currentVertex.getLabel() + " ");

        List<Edge> edges = getEdges(currentVertex);
        for (Edge edge : edges) {
            Vertex neighbor = getNeighbor(edge, currentVertex);
            int neighborIndex = getIndex(neighbor);
            if (!visited[neighborIndex]) {
                visited[neighborIndex] = true;
                queue.enqueue(neighbor);
            }
        }
    }
}
// REPORT: was throwing a nullpointerexception for ages, added null checks to ensure start or end is not null before invoking their methods//
//(edge != null, edge.getStart() != null, and edge.getEnd() != null) to ensure that all necessary objects are non-null before accessing their methods.//
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
    int i = 0;
    boolean found = false;
    while (i < vertexCount && !found) {
        found = vertices[i].equals(vertex);
        i++;
    }
    return found;
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
        return Arrays.asList(Arrays.copyOf(vertices, vertexCount));
    }

    // Class to initialize vertices and associated values
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