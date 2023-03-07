import java.util.*;
class Factorial
{
    public static void main(String[] args)
    {
        int min = 1;
        int max = 2;
        long facNumber = 0;
        Scanner input = new Scanner(System.in);

        System.out.println("Please select which formula to use");
        System.out.println("1 - Iterative formula");
        System.out.println("2 - Recursive formula");
        int formulaToUse = input.nextInt();
        if (formulaToUse > max || formulaToUse < min)
        {
            throw new IllegalArgumentException("Invalid input: Must select either 1 or 2");
        }

        System.out.println("Please enter Factorial number to begin with");
        int userInt = input.nextInt();
    }
}