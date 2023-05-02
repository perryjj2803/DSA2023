import java.util.*;
public class DSABinarySearchTreeTestHarness
{
    public static void main(String[] args)
    {
        String min, max;
        DSABinarySearchTree BinarySearchTree = new DSABinarySearchTree();
        BinarySearchTree.insert("A", 10);
        BinarySearchTree.insert("B", 20);
        BinarySearchTree.insert("C", 30);
        BinarySearchTree.insert("D", 40);
        BinarySearchTree.insert("E", 50);

        min = BinarySearchTree.minIter(BinarySearchTree.m_root);
        max = BinarySearchTree.maxIter(BinarySearchTree.m_root);

        System.out.println("min key is: " + min + " and max key is: " + max);
    }
}





