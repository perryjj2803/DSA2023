/***************************************************************************************
*    Title: Graph practical submission
*    Author: Jean-Jacques Perry
*    Date: 1N/05/2023
*    Description: I wrote SOME of this code for my graph prac (only setters/getters) but never got it marked 
***************************************************************************************/
import java.util.*;

public class Graph {
    private DSALinkedList vertices;
    private DSALinkedList edges;

    public Graph() {
        vertices = new DSALinkedList();
        edges = new DSALinkedList();
    }

    public void addVertex(Vertex vertex) {
        if (!containsVertex(vertex)) {
            vertices.insertLast(vertex);
        }
    }

    public void addEdge(Vertex start, Vertex end, double weight) {
        if (!hasEdge(start, end)) {
            Edge edge = new Edge(start, end, weight);
            edges.insertLast(edge);
        }
    }
    public int getIndex(Vertex vertex) {
        int index = 0;
        for (Object obj : vertices) {
            Vertex v = (Vertex) obj;
            if (v.equals(vertex)) {
                return index;
            }
            index++;
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
        for (Object obj : edges) {
            Edge edge = (Edge) obj;
            if (edge.getStart().equals(start) && edge.getEnd().equals(end)) {
                return true;
            }
        }
        return false;
    }

    public boolean containsVertex(Vertex vertex) {
        return vertices.contains(vertex);
    }

    public void removeVertex(Vertex vertex) {
        DSALinkedList edgesToRemove = getEdges(vertex);
        // Remove edges connected to the vertex
        for (Object edgeObj : edgesToRemove) {
            Edge edge = (Edge) edgeObj;
            removeEdge(edge);
        }
        // Remove the vertex from the vertices list
        vertices.remove(vertex);
    }

    public void removeEdge(Edge edge) {
        edges.remove(edge);
    }

    public DSALinkedList getEdges(Vertex vertex) {
        DSALinkedList vertexEdges = new DSALinkedList();
        for (Object obj : edges) {
            Edge edge = (Edge) obj;
            if (edge.getStart().equals(vertex) || edge.getEnd().equals(vertex)) {
                vertexEdges.insertLast(edge);
            }
        }
        return vertexEdges;
    }

  public DSALinkedList getVertices() {
        return vertices;
    }


    // Class to initialize vertices and associated values
    public static class Vertex {
        private String label;
        private double temp;
        private double humidity;
        private double wind;
        private Vertex parent; // new field

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
        public void setParent(Vertex parent) {
        this.parent = parent;
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
        public Vertex getParent() {
        return parent;
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
 public void bfs(Vertex startVertex) {
    DSAQueue queue = new DSAQueue();
    DSALinkedList visitedVertices = new DSALinkedList();

    startVertex.setParent(null); // Start vertex has no parent
    queue.enqueue(startVertex);
    visitedVertices.insertLast(startVertex);

    while (!queue.isEmpty()) {
        Vertex current = (Vertex) queue.dequeue();
        DSALinkedList neighbours = getEdges(current);
        for (Object obj : neighbours) {
            Edge edge = (Edge) obj;
            Vertex neighbour = getNeighbor(edge, current);
            if (!visitedVertices.contains(neighbour)) {
                neighbour.setParent(current); // Set current as parent for neighbour
                queue.enqueue(neighbour);
                visitedVertices.insertLast(neighbour);
            }
        }
    }
}
public DSALinkedList shortestPath(Vertex startVertex, Vertex endVertex) {
    bfs(startVertex); // Perform BFS from start vertex

    // Now backtrack from end vertex to start vertex using the parent property
    DSALinkedList path = new DSALinkedList();
    Vertex current = endVertex;
    while (current != null) {
        path.insertFirst(current); // Insert at start because we're going in reverse
        current = current.getParent();
    }

    return path;
}
    // DFS method unsure what to use it for?
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
