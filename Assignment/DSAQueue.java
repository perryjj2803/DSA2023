import java.util.*;
import java.util.Arrays;
public class DSAQueue
{
    private Object[] queue;
    private Object value;
    private int front, rear;
    public boolean empty, full;
    private double topVal;
    private int count;

    public static final int DEFAULT_CAPACITY = 100;
 
    public DSAQueue()
    {
        queue = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public DSAQueue(int maxCapacity)
    {
        queue = new Object[maxCapacity];
        count = 0;
    }


    public int getCount()
    {
        return count;
    }

    public boolean isEmpty()
    {
        if(count != 0)
        {
            empty = false;
        }
        else
        {
            empty = true;
        }
        return empty;
    }

    public boolean isFull()
    {
        if(count == queue.length)
        {
            full = true;
        }
        else
        {
            full = false;
        }
        return full;
    }

    public void enqueue(Object value)
    {
        if(isFull())
        {
            System.out.print( "Queue is full" );
        }
        else
        {
            queue[rear] = value;
            rear = rear+1;
            count = count+1;
        }
    }

    public Object dequeue()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException( "Queue is empty" );
        }
        else
        {
            Object value = queue[front];
            queue[front] = 0;
            front = front+1;
            count = count-1;
    
            return value;
        }
    }

// REPORT: Modified peek method to work with BFS
   public Object peek() {
        if (isEmpty()) {
            throw new IllegalArgumentException("Queue is empty");
        } else {
            return queue[front];
        }
    }

    
    public void show()
    {
        System.out.println(Arrays.toString(queue));
    }
}