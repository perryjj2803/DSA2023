import java.util.*;

class Towers
{
    public static void main(String args[])
    {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter number of disks: ");
        int n = input.nextInt();
        towersOfHanoi(n, 1, 3);
        
    }

    public static void towersOfHanoi(int n, int src, int dst)
    {
        int tmp;
        if (n==1)
        {
            moveDisk(n, src, dst);
        }
        else
        {
            tmp = 6-src-dst;
            towersOfHanoi(n-1, src, tmp);
            moveDisk(n, src, dst);
            towersOfHanoi(n-1, tmp, dst);
        }
    }

    public static void moveDisk(int n, int src, int dst)
    {
        if(n==3)
        {
            System.out.println("Recurive Level=1");
            System.out.println("Moving Disk " + n + " from Source " + src + " to Destination " + dst);
            System.out.println("n="+n +" src="+src +" dst="+dst);
        }
        else if(n==2)
        {
            System.out.println("        Recurive Level=2");
            System.out.println("        Moving Disk " + n + " from Source " + src + " to Destination " + dst);
            System.out.println("        n="+n +" src="+src +" dst="+dst);
        }
        else
        {
            System.out.println("                Recurive Level=3");
            System.out.println("                Moving Disk " + n + " from Source " + src + " to Destination " + dst);
            System.out.println("                n="+n +" src="+src +" dst="+dst);
        }

    }
}