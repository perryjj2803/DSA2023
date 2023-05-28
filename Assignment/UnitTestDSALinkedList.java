import java.util.*;
public class UnitTestDSALinkedList {
    public static void main(String[] args) {
        // Create a new instance of DSALinkedList
        DSALinkedList list = new DSALinkedList();

        // Test insertFirst and insertLast methods
        list.insertFirst("First");
        list.insertLast("Last");

        // Test isEmpty method
        System.out.println("Is list empty? " + list.isEmpty());

        // Test peekFirst and peekLast methods
        System.out.println("First item: " + list.peekFirst());
        System.out.println("Last item: " + list.peekLast());

        // Test removeFirst and removeLast methods
        System.out.println("Removed first item: " + list.removeFirst());
        System.out.println("Removed last item: " + list.removeLast());

        // Test isEmpty method again
        System.out.println("Is list empty? " + list.isEmpty());

        // Test insertFirst and remove methods with multiple elements
        list.insertFirst("First");
        list.insertFirst("New First");
        list.insertLast("Last");
        try {
            list.remove("First");
            System.out.println("Removed item: First");
        } catch (NoSuchElementException e) {
            System.out.println("Item 'First' not found");
        }

        // Test print method
        System.out.println("Items in the list:");
        list.print();

        // Test contains method
        System.out.println("Does list contain 'New First'? " + list.contains("New First"));
        System.out.println("Does list contain 'Last'? " + list.contains("Last"));
    }
}
