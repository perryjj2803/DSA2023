//did not re-use this code, had to write it for the assignment as I did not complete the practical in time
import java.util.*;
public class HashMap {
    private class MapNode {
        Vertex key;
        Vertex value;

        MapNode(Vertex key, Vertex value) {
            this.key = key;
            this.value = value;
        }
    }

    private DSALinkedList[] buckets;  // An array of linked lists

    public HashMap(int size) {
        this.buckets = new DSALinkedList[size];
        for (int i = 0; i < size; i++) {
            this.buckets[i] = new DSALinkedList();
        }
    }

    private int getBucketIndex(Vertex key) {
        return key.hashCode() % buckets.length;
    }

    public void put(Vertex key, Vertex value) {
        int bucketIndex = getBucketIndex(key);
        MapNode newNode = new MapNode(key, value);
        buckets[bucketIndex].insertLast(newNode);
    }

    public Vertex get(Vertex key) {
        int bucketIndex = getBucketIndex(key);
        DSALinkedList bucket = buckets[bucketIndex];
        for (Object obj : bucket) {
            MapNode node = (MapNode) obj;
            if (node.key.equals(key)) {
                return node.value;
            }
        }
        return null;  // If no such key exists, return null
    }
}