import java.util.*;
public class DSALinkedListTestHarness
{
    public static void main(String[] args)
    {
        DSALinkedList LinkedList = new DSALinkedList();

        System.out.println("----------");
        LinkedList.insertFirst("1");
        LinkedList.insertLast("2");
        LinkedList.insertLast("3");
        LinkedList.iterateOverList(LinkedList);
        System.out.println("----------");

        LinkedList.removeFirst();
        LinkedList.iterateOverList(LinkedList);

        System.out.println("----------");

        LinkedList.isEmpty();

    }

}