import java.util.*;
public class DSALinkedList implements Iterable
{
    private class DSAListNode
    {
        public Object value;
        public DSAListNode next;

        public DSAListNode(Object inValue)
        {
            value = inValue;
            next = null;
        }

        public Object getValue()
        {
            return value;
        }

        public void setValue(Object inValue)
        {
            value = inValue;
        }

        public DSAListNode getNext()
        {
            return next;
        }

        public void setNext(DSAListNode newNext)
        {
            next = newNext;
        }

        
    }
    
    public DSAListNode head;
    public DSAListNode tail;
    private DSAListNode newNd;
    private DSAListNode currNd;
    private Object nodeValue;
    private boolean empty;
                

    public DSALinkedList()
    {
        head = null;
        tail = null;
    }

    public void insertFirst(Object newValue) //Replace head with new node//
    {
        newNd = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = tail = newNd;
        }
        else
        {
            newNd.setNext(head);
            head = newNd;
        }
    }

    public void insertLast(Object newValue)
    {
        newNd = new DSAListNode(newValue);
        if(isEmpty())
        {
            head = tail = newNd;
        }    
        else
        {
            tail.setNext(newNd);
            tail = newNd;
        }
    }    

    public boolean isEmpty()
    {
        return empty = (head == null);
    }

    public Object peekFirst()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else
        {
            nodeValue = head.getValue();
        }     
        return nodeValue;   
    }

    public Object peekLast()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException( "List is empty" );
        } 
        else
        {
            currNd = head;
            while(currNd.getNext()!=null)
            {    
                currNd = currNd.getNext();
            }
            nodeValue = currNd.getValue();
        }
        return nodeValue;
    }

    public Object removeFirst()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else if(head.getNext() == null)
        {
            nodeValue = head.getValue();
            head = null;
        }
        else
        {
            nodeValue = head.getValue();
            head = head.getNext();
        }
        return nodeValue;
            
    }    

    public Object removeLast()
    {
        if(isEmpty())
        {
            throw new IllegalArgumentException( "List is empty" );
        }
        else if(head.getNext() == null)
        {
            nodeValue = head.getValue();
            head = null;
        }
        else
        {
            currNd = tail;
            currNd = currNd.getNext();
        }
        tail.setNext(null);
        nodeValue = currNd.getValue();

        return nodeValue;
    }
    public void print()
    {
        DSAListNode n = head;
        while(n.getNext() != null)
        {
            System.out.println(n.getValue());
            n = n.getNext();
        }
    
    }
    public void iterateOverList(DSALinkedList theList)
    {
        Object c;
        int count = 0;
        Iterator iter = theList.iterator();
        while(iter.hasNext())
        {
            c = (Object)iter.next();
            count++;
            System.out.println(c);
            System.out.println("count = " + count );
        }
    }
    public Iterator iterator()
    {
        return new DSALinkedListIterator(this);
    }
    private class DSALinkedListIterator implements Iterator
    {
        private DSAListNode iterNext;
        public DSALinkedListIterator(DSALinkedList theList)
        {
            iterNext = theList.head;
        }
        public boolean hasNext()
        {
            return (iterNext != null);
        }
        public Object next()
        {
            Object value;
            if(iterNext == null)
            {
                value = null;
            }
            else
            {
                value = iterNext.getValue();
                iterNext = iterNext.getNext();
            }
            return value;
        }
        public void remove() {throw new UnsupportedOperationException("Not supported"); }
    }
}
    