import java.util.*;
public class DSABinarySearchTree
{
    private class TreeNode
    {
        private String m_key;
        private Object m_value;
        private TreeNode m_leftChild;
        private TreeNode m_rightChild;

        public TreeNode(String inKey, Object inVal)
        {
            if(inKey == null)
            {
                throw new IllegalArgumentException("Key cannot be null");
            }
            m_key = inKey;
            m_value = inVal;
            m_rightChild = null;
            m_leftChild = null;
        }
        public String getKey()
        {
            return m_key;
        }
        public Object getValue()
        {
            return m_value;
        }
        public TreeNode getLeft()
        {
            return m_leftChild;
        }
        public void setLeft(TreeNode newLeft)
        {
            m_leftChild = newLeft;
        }
        public TreeNode getRight()
        {
            return m_rightChild;
        }
        public void setRight(TreeNode newRight)
        {
            m_rightChild = newRight;
        }
    }

    public TreeNode m_root;

    public DSABinarySearchTree()
    {
        m_root = null;
    }

    public Object find(String key)
    {
        return findRec(key, m_root);
    }

    public TreeNode insert(String key, Object data)
    {
        return insertRec(key, data, m_root);
    }

    public TreeNode delete(String key)
    {
        return deleteRec(key, m_root);
    }

    public int height()
    {
        return heightRec(m_root);
    }


    private Object findRec(String key, TreeNode currNode)
    {
        Object value = null;

        if(currNode == null)
        {
            throw new NoSuchElementException("Key " + key + " not found");
        }
        else if(key.equals(currNode.getKey()))
        {
            value = currNode.getValue();
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            value = findRec(key, currNode.getLeft());
        }
        else
        {
            value = findRec(key, currNode.getRight());
        }
        return value;
    }

    private TreeNode insertRec(String key, Object data, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if(currNode == null)
        {
            TreeNode newNode = new TreeNode(key, data);
            updateNode = newNode;
        }
        else if(key.equals(currNode.getKey()))
        {
            throw new IllegalArgumentException("Key is the same as current node");
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(insertRec(key, data, currNode.getLeft()));    
        }
        else
        {
            currNode.setRight(insertRec(key, data, currNode.getRight()));
        }
        return updateNode;
    }

    public TreeNode deleteRec(String key, TreeNode currNode)
    {
        TreeNode updateNode = currNode;
        if(currNode == null)
        {
            throw new IllegalArgumentException("No node to delete");
        }
        else if(key.equals(currNode.getKey()))
        {
            updateNode = deleteNode(key, currNode);
        }
        else if(key.compareTo(currNode.getKey()) < 0)
        {
            currNode.setLeft(deleteRec(key, currNode.getLeft()));
        }
        else
        {
            currNode.setRight(deleteRec(key, currNode.getRight()));
        }
        return updateNode;
    }

    private TreeNode deleteNode(String key, TreeNode delNode)
    {
        TreeNode updateNode = null;
        if((delNode.getLeft() == null) && (delNode.getRight() == null))
        {
            updateNode = null;
        }
        else if((delNode.getLeft() != null) && (delNode.getRight() == null))
        {
            updateNode = delNode.getLeft();
        }
        else if((delNode.getLeft() == null) && (delNode.getRight() != null))
        {
            updateNode = delNode.getRight();
        }
        else
        {
            updateNode = promoteSuccessor(delNode.getRight());
            if(updateNode != delNode.getRight())
            {
                updateNode.setRight(delNode.getRight());
            }
            updateNode.setLeft(delNode.getLeft());
        }
        return updateNode;
    }

    private TreeNode promoteSuccessor(TreeNode currNode)
    {   
        TreeNode successor = currNode;
        if(currNode.getLeft() != null)
        {
            successor = promoteSuccessor(currNode.getLeft());
            if(successor == currNode.getLeft())
            {
                currNode.setLeft(successor.getRight());
            }
        }
        return successor;
    }

    public String minIter(TreeNode currNode)
{
    String minKey = null;
    while (currNode != null)
    {
        minKey = currNode.getKey();
        currNode = currNode.getLeft();
    }
    return minKey;
}

    public String maxIter(TreeNode currNode)
    {
        String maxKey;
        while(currNode.getRight() != null)
        {
            currNode = currNode.getRight();
        }
        maxKey = currNode.getKey();
        return maxKey;
    }

    public int heightRec(TreeNode currNode)
    {
        int htSoFar, iLeftHt, iRightHt;
        if(currNode == null)
        {
            htSoFar = -1;
        }
        else
        {
            iLeftHt = heightRec(currNode.getLeft());
            iRightHt = heightRec(currNode.getRight());
            if(iLeftHt > iRightHt)
            {
                htSoFar = iLeftHt + 1;
            }
            else
            {
                htSoFar = iRightHt +1;
            }
        }
        return htSoFar;
    }

    public void display()
    {

    }

    public void printPreOrder(TreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        System.out.println("node key: " + currNode.getKey());
        printPreOrder(currNode.getLeft());
        printPreOrder(currNode.getRight());
    }

    public void printInOrder(TreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        printInOrder(currNode.getLeft());
        System.out.println("node key: " + currNode.getKey());
        printInOrder(currNode.getRight());
    }

    public void printPostOrder(TreeNode currNode)
    {
        if(currNode == null)
        {
            return;
        }
        printPostOrder(currNode.getLeft());
        printPostOrder(currNode.getRight());
        System.out.println("node key: " + currNode.getKey());
    }
}