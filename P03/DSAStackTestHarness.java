import java.util.*;
public class DSAStackTestHarness
{
    public static void main(String[] args)
    {
        DSAStack dsaStack = new DSAStack(6);

            dsaStack.push(1);
            dsaStack.push(2);
            dsaStack.push(3);
            dsaStack.push(4);
            dsaStack.push(5);
            dsaStack.push(6);

            dsaStack.show();

            dsaStack.pop();
            dsaStack.pop();
            dsaStack.show();

            dsaStack.pop();
            dsaStack.pop();
            dsaStack.pop();
            dsaStack.pop();
            dsaStack.show();

            try
            {
                dsaStack.pop();
            }
            catch (Exception e)
            {
                System.out.println("Stack is empty");
            }

            dsaStack.push(7);
            dsaStack.push(8);
            dsaStack.push(9);
            dsaStack.push(10);
            dsaStack.push(11);
            dsaStack.push(12);
            dsaStack.show();

            try
            {
                dsaStack.push(13);
            }
            catch (Exception e)
            {
                System.out.println("Stack is full");
            }


    }
}