import java.util.*;
class DSAGraph
{
    class DSAGraphVertex
    {
        private String label;
        private Object value;
        private LinkedList<DSAGraphVertex> links;
        private boolean visited;

        public DSAGraphVertex(String inLabel, Object inValue)
        {
            label = inLabel;
            value = inValue;
            links = new LinkedList<>();
            visited = false;
        }

        public String getLabel()
        {
            return label;
        }

        public Object getValue()
        {
            return value;
        }

        public List<DSAGraphVertex> getAdjacent()
        {
            return links;
        }

        public void addEdge(DSAGraphVertex vertex)
        {
            links.add(vertex);
        }

        public void setVisited()
        {
            visited = true;
        }

        public void clearVisited()
        {
            visited = false;
        }

        public boolean getVisited()
        {
            return visited;
        }

        public String toString()
        {
            StringBuilder sb = new StringBuilder();
            sb.append(label).append(" -> ");
            for (DSAGraphVertex vertex : links)
            {
                sb.append(vertex.getLabel()).append(", ");
            }
            return sb.toString();
        }
    }

    private LinkedList<DSAGraphVertex> vertices;
    public DSAGraph()
    {
        vertices = new LinkedList<>();
    }

    public void addVertex(String label, Object value)
    {
        vertices.add(new DSAGraphVertex(label, value));
    }

    public void addEdge(String label1, String label2)
    {
        DSAGraphVertex vertex1 = getVertex(label1);
        DSAGraphVertex vertex2 = getVertex(label2);
        vertex1.addEdge(vertex2);
        vertex2.addEdge(vertex1);
    }

    public boolean hasVertex(String label)
    {
        return getVertex(label) != null;
    }

    public int getVertexCount()
    {
        return vertices.size();
    }

    public int getEdgeCount()
    {
        int count = 0;
        for (DSAGraphVertex vertex : vertices)
        {
            count += vertex.getAdjacent().size();
        }
        return count / 2;
    }

    public DSAGraphVertex getVertex(String label)
    {
        DSAGraphVertex result = null;
        for (DSAGraphVertex vertex : vertices)
        {
            if (vertex.getLabel().equals(label))
            {
                result = vertex;
                break;
            }
        }
        return result;
    }

    public List<DSAGraphVertex> getAdjacent(String label)
    {
        return getVertex(label).getAdjacent();
    }

    public boolean isAdjacent(String label1, String label2)
    {
        return getVertex(label1).getAdjacent().contains(getVertex(label2));
    }

    public void displayAsList()
    {
        for (DSAGraphVertex vertex : vertices)
        {
            System.out.println(vertex);
        }
    }

    public void displayAsMatrix()
    {
        for (DSAGraphVertex row : vertices)
        {
            for (DSAGraphVertex col : vertices)
            {
                System.out.print(isAdjacent(row.getLabel(), col.getLabel()) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}

