import java.util.*;

class recursiveFibonacci
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        
        System.out.println("Please enter Fibonacci number");
        int userInt = input.nextInt();
        int fibNumber = fibRecursive(userInt);
        System.out.println("The number is " + fibNumber);
    }
    public static int fibRecursive(int n)
    {
        int fibVal = 0;

        if(n == 0)
        {
            fibVal = 0;
        }
        else if(n == 1)
        {
            fibVal = 1;
        }
        else
        {
            fibVal = fibRecursive(n-1) + fibRecursive(n-2);
        }
        return fibVal;
    }
}