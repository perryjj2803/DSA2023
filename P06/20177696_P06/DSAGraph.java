import java.util.*;

class DSAGraph
{
    class DSAGraphNode
    {
        private String label;
        private Object value;
        private LinkedList<DSAGraphNode> links;
        private boolean visited;

        public DSAGraphNode(String inLabel, Object inValue)
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

        public List<DSAGraphNode> getAdjacent()
        {
            return links;
        }

        public void addEdge(DSAGraphNode node)
        {
            links.add(node);
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
            for (DSAGraphNode node : links)
            {
                sb.append(node.getLabel()).append(", ");
            }
            return sb.toString();
        }
    }

    private LinkedList<DSAGraphNode> nodes;

    public DSAGraph()
    {
        nodes = new LinkedList<>();
    }

    public void addNode(String label, Object value)
    {
        nodes.add(new DSAGraphNode(label, value));
    }

    public void addEdge(String label1, String label2)
    {
        DSAGraphNode node1 = getNode(label1);
        DSAGraphNode node2 = getNode(label2);
        node1.addEdge(node2);
        node2.addEdge(node1);
    }

    public boolean hasNode(String label)
    {
        return getNode(label) != null;
    }

    public int getNodeCount()
    {
        return nodes.size();
    }

    public int getEdgeCount()
    {
        int count = 0;
        for (DSAGraphNode node : nodes)
        {
            count += node.getAdjacent().size();
        }
        return count / 2;
    }

    public DSAGraphNode getNode(String label)
    {
        DSAGraphNode result = null;
        for (DSAGraphNode node : nodes)
        {
            if (node.getLabel().equals(label))
            {
                result = node;
                break;
            }
        }
        return result;
    }

    public List<DSAGraphNode> getAdjacent(String label)
    {
        return getNode(label).getAdjacent();
    }

    public boolean isAdjacent(String label1, String label2)
    {
        return getNode(label1).getAdjacent().contains(getNode(label2));
    }

    public void displayAsList()
    {
        for (DSAGraphNode node : nodes)
        {
            System.out.println(node);
        }
    }

    public void displayAsMatrix()
    {
        for (DSAGraphNode row : nodes)
        {
            for (DSAGraphNode col : nodes)
            {
                System.out.print(isAdjacent(row.getLabel(), col.getLabel()) ? "1 " : "0 ");
            }
            System.out.println();
        }
    }
}
