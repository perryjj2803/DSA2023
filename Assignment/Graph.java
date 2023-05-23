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
  public void removeVertex(Vertex vertex) {
        DSALinkedList edgesToRemove = getEdges(vertex);
        
        // Remove edges connected to the vertex
        for (Object edgeObj : edgesToRemove) {
            Edge edge = (Edge) edgeObj;
            removeEdge(edge);
        }
        
        // Remove the vertex from the vertices array
        int index = getIndex(vertex);
        if (index != -1) {
            for (int i = index; i < vertexCount - 1; i++) {
                vertices[i] = vertices[i + 1];
            }
            vertices[vertexCount - 1] = null;
            vertexCount--;
        }
    }

    public void removeEdge(Edge edge) {
        for (int i = 0; i < edgeCount; i++) {
            if (edges[i].equals(edge)) {
                edges[i] = edges[edgeCount - 1];
                edges[edgeCount - 1] = null;
                edgeCount--;
                break;
            }
        }
    }

    public DSALinkedList getEdges(Vertex vertex) {
        DSALinkedList vertexEdges = new DSALinkedList();
        for (int i = 0; i < edgeCount; i++) {
            Edge edge = edges[i];
            if (edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)) {
                vertexEdges.insertLast(edge);
            }
        }
        return vertexEdges;
    }

    public DSALinkedList getVertices() {
        DSALinkedList verticesList = new DSALinkedList();
        for (int i = 0; i < vertexCount; i++) {
            verticesList.insertLast(vertices[i]);
        }
        return verticesList;
    }

    // Class to initialize vertices and associated values
    public static class Vertex {
        private String label;
        private double temp;
        private double humidity;
        private double wind;

        public Vertex(String label) {
            this.label = label;
        }

        //Setter nethods
        public void setTemp(double temp) {
            this.temp = temp;
        }

        public void setHumidity(double humidity) {
            this.humidity = humidity;
        }

        public void setWind(double wind) {
            this.wind = wind;
        }

        //Getter methods
        public String getLabel() {
            return label;
        }

        public double getTemp() {
            return temp;
        }

        public double getHumidity() {
            return humidity;
        }

        public double getWind() {
            return wind;
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
    public DSALinkedList bfs(Vertex startVertex) {
        DSAQueue queue = new DSAQueue();
        DSALinkedList visitedVertices = new DSALinkedList();

        queue.enqueue(startVertex);
        visitedVertices.insertLast(startVertex);

        while (!queue.isEmpty()) {
            Vertex current = (Vertex) queue.dequeue();
            DSALinkedList neighbours = getEdges(current);
            for (Object obj : neighbours) {
                Edge edge = (Edge) obj;
                Vertex neighbour = getNeighbor(edge, current);
                if (!visitedVertices.contains(neighbour)) {
                    queue.enqueue(neighbour);
                    visitedVertices.insertLast(neighbour);
                }
            }
        }
        return visitedVertices;
    }

    // DFS method
    public DSALinkedList dfs(Vertex startVertex) {
        DSALinkedList stack = new DSALinkedList();
        DSALinkedList visitedVertices = new DSALinkedList();

        stack.insertLast(startVertex);

        while (!stack.isEmpty()) {
            Vertex current = (Vertex) stack.removeLast();
            if (!visitedVertices.contains(current)) {
                visitedVertices.insertLast(current);
                DSALinkedList neighbours = getEdges(current);
                for (Object obj : neighbours) {
                    Edge edge = (Edge) obj;
                    Vertex neighbour = getNeighbor(edge, current);
                    stack.insertLast(neighbour);
                }
            }
        }
        return visitedVertices;
    }
    
    // Helper method to check if the linked list contains a vertex
    public boolean contains(DSALinkedList list, Vertex vertex) {
        for (Object obj : list) {
            Vertex v = (Vertex) obj;
            if (v.equals(vertex)) {
                return true;
            }
        }
        return false;
    }
}
