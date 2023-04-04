import java.util.*;
public class CallStackTestHarness
{
    public static void main(String[] args)
    {
        DSAStack callStack = new CallStack(3);

        dsaStack.push(RecursiveCalcNFactorial(10));
        dsaStack.push(GreatestCommonDenominator(10,20));
        dsaStack.push(RecursiveFibonacci(10));

        dsaStack.show();

    }
}