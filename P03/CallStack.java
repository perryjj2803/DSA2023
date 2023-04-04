import java.util.*;
public class CallStack extends DSAStack
{
    private Object[] callStack;
    
    public CallStack()
    {
        super();
    }

    public void RecursiveCalcNFactorial(int n)
    {
        String methodName = "recursive factorial";
        String arguments = "int n=" + n;
    }

    public void GreatestCommonDenominator(int numOne, int numTwo)
    {
        String methodName = "recursive GCD";
        String arguments = "int numOne=" + numOne + "int numTwo=" + numTwo;
    }

    public void RecursiveFibonacci(int n)
    {
        String methodName = "recursive Fibonacci";
        String arguments = "int n=" + n;
    }
}