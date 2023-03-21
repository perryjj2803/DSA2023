import java.util.*;

class numberConversions
{
    public static void main(String[] args)
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter base 10 number to convert ");
        int num = input.nextInt();
        System.out.println("What base system converting to? enter number between 2 and 16 inclusive ");
        int conversionBase = input.nextInt();
        if (conversionBase > 16 || conversionBase < 2)
        {
            throw new IllegalArgumentException("Must_enter_number_between_2_and_16_inclusive");
        }
        else if (conversionBase == 10)
        {
            throw new IllegalArgumentException("Number_is_already_base_10");
        }
        else
        {
            String result = baseConversion(num, conversionBase);
            System.out.println("Result is " + result );
        }
    }

    public static String baseConversion(int num, int conversionBase)
    {
        int result = num / conversionBase;
        int remainder = num % conversionBase;
        String conversionResult;

        if(result == 0)
        {
            conversionResult = Integer.toString(remainder);
        }
        else
        {
            conversionResult = baseConversion(result, conversionBase) + Integer.toString(remainder);
        }
        return conversionResult;
    }
        
}