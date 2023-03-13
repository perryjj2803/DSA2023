import java.util.*;

class Factorial 
{
    public static void main(String[] args) 
    {
        Scanner scanner = new Scanner(System.in);
        int userInput;
        int n;
        boolean exitProgram = false;

        while (!exitProgram) 
        {
            System.out.println("Menu:");
            System.out.println("1. Iterative Factorial");
            System.out.println("2. Recursive Factorial");
            System.out.println("0. Exit");

            System.out.print("Enter your choice: ");
            userInput = scanner.nextInt();

            if (userInput == 1) 
            {
                System.out.print("Enter a number to calculate the factorial of: ");
                n = scanner.nextInt();
                long factorial = iterativeCalcNFactorial(n);
                System.out.println("The factorial of " + n + " is " + factorial);
            } 
            else if (userInput == 2) 
            {
                System.out.print("Enter a number to calculate the factorial of: ");
                n = scanner.nextInt();
                long factorial = recursiveCalcNFactorial(n);
                System.out.println("The factorial of " + n + " is " + factorial);
            } 
            else if (userInput == 0) 
            {
                System.out.println("Exiting program...");
                exitProgram = true;
            } 
            else 
            {
                System.out.println("Invalid choice! Please try again.");
            }
        }
    }

    public static long iterativeCalcNFactorial(int n) 
    {
        long nFactorial = 1;
        for (int ii = n; ii >= 2; ii--) 
        {
            nFactorial *= ii;
        }
        return nFactorial;
    }

    public static long recursiveCalcNFactorial(int n) 
    {
        if (n == 0) 
        {
            return 1;
        } 
        else 
        {
            return n * recursiveCalcNFactorial(n - 1);
        }
    }
}
