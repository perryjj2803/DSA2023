import java.util.*;
public class DSAQueueTestHarness
{
    public static void main(String[] args)
    {
        System.out.println("Shuffling queue testing: ");
        DSAQueue dsaQueue = new DSAQueue(4);

        dsaQueue.enqueue(1);
        dsaQueue.enqueue(2);
        dsaQueue.enqueue(3);
        dsaQueue.enqueue(4);
        dsaQueue.show();

        try
        {
            dsaQueue.enqueue(5);
        }
        catch (Exception e)
        {
            System.out.println("Queue is full");
        }

        dsaQueue.dequeue();
        dsaQueue.dequeue();
        dsaQueue.dequeue();
        dsaQueue.dequeue();
        dsaQueue.show();

        try
        {
            dsaQueue.dequeue();
        }
        catch (Exception e)
        {
            System.out.println("Queue is empty");
        }

        System.out.println("Circular queue testing:\n");

        DSAQueue circQueue = new DSACircularQueue(5);

        circQueue.enqueue(2);
        circQueue.enqueue(4);
        circQueue.enqueue(6);
        circQueue.enqueue(8);
        circQueue.enqueue(10);
        circQueue.show();

        try
        {
            circQueue.enqueue(12);
        }
        catch (Exception e)
        {
            System.out.println("Queue is full");
        }

        circQueue.dequeue();
        circQueue.dequeue();
        circQueue.show();

        circQueue.dequeue();
        circQueue.dequeue();
        circQueue.dequeue();
        circQueue.show();

        try
        {
            circQueue.dequeue();
        }
        catch (Exception e)
        {
            System.out.println("Queue is empty");
        }
    }
}
            