import java.util.*;
public class DSAStack
{
    private Object[] stack;
    private int count;
    private boolean empty, full;
    private double value, topVal;

    public static final int DEFAULT_CAPACITY = 100;

    public DSAStack()
    {
        stack = new Object[DEFAULT_CAPACITY];
        count = 0;
    }

    public DSAStack(int maxCapacity)
    {
        stack = new Object[maxCapacity];
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
        if(count == stack.length)
        {
            full = true;
        }
        else
        {
            full = false;
        }
        return full;
    }

    public void push(Object value)
    {
        if(isFull())
        {
            throw new IllegalArgumentException( "Stack is full" );
        }
        else
        {
            stack[count] = value;
            count = count+1;
        }
    }
    public double pop()
    {
        topVal = top();
        stack[count-1] = 0;
        count = count-1;
        return topVal;
    }

    public double top()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException( "Stack is empty" );
        }
        else
        {
            Object topVal = stack[count-1];
        }
        return topVal;
    }

    public void show()
    {
        System.out.println(Arrays.toString(stack));
    }
}