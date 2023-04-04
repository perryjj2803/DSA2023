import java.util.*;
public class DSACircularQueue extends DSAQueue
{
    private Object[] queue;
    private Object value;
    private int front, rear, count;
    private boolean empty, full;
    private double frontVal;
    
    public DSACircularQueue()
    {
        super();
    }

    public DSACircularQueue(int maxCapacity)
    {
        super(maxCapacity);
    }
    
    public void enqueue(Object value, Object[] queue)
    {
        super.enqueue(value);
        rear = rear%queue.length;
    }

    public Object dequeue(Object[] queue)
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException( "Queue is empty" );
        }
        else
        {
            queue[front] = 0;
            Object value = queue[front];
            front = (front+1)%count;
            count = count-1;
        }
        return value;
    }
       
    public boolean isEmpty()
    {
        super.isEmpty(); 
        return empty;
    }
}


