import java.util.*;

class iterativeFibonacci
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);

        System.out.println("Please enter Fibonacci number");
        int userInt = input.nextInt();
        int fibNumber = fibIterative(userInt);
        System.out.println("The number is " + fibNumber);
    }
    public static int fibIterative(int n)
    {
        int fibVal = 0;
        int currVal = 1;
        int lastVal = 0;

        if(n == 0)
        {
            fibVal = 0;
        }
        else if (n == 1)
        {
            fibVal = 1;
        }
        else
        {
            for(int ii = 2; ii < n+1; ii++)
            {
                fibVal = currVal + lastVal;
                lastVal = currVal;
                currVal = fibVal;
            }
        }
        return fibVal;
    }
}