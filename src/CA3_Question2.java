import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Eoin Hamill
 *  Class Group: GD2a
 */
public class CA3_Question2
{
    /*
        Starter function to create the 2D array and populate it with 0

     */
    public static int[][]  floodFillStart() {
        Scanner kb = new Scanner(System.in);
        int[][] arr = new int[10][10];
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                arr[x][y] = 0;
            }
        }
       return arr;
    }
    /*
        Helper function to display the image
     */
    public static void display(int[][] arr)
    {
        for (int x = 0; x < 10; x++)
        {
            for (int y = 0; y < 10; y++)
            {
                System.out.printf("%4d", arr[x][y]);
            }
            System.out.println();
        }
    }
    private static void fill(int r, int c, int[][] arr)
    {

    }

    public static void start()
    {
        //Creating stack of pairs
        Stack<pair> pairs = new Stack<pair>();
       int[][] arr = floodFillStart();
       System.out.println("Stack before fill:\n");
       display(arr);
       Scanner input = new Scanner(System.in);
       System.out.println("Please enter the x location.");
       int x= input.nextInt();
       System.out.println("Please enter the y location.");
       int y= input.nextInt();
       //putting the pair ontop of the stack
       pairs.push(new pair(x,y));
       System.out.println("Current Pairs"+pairs);
       boolean finished=false;
       //filling in first letter
       arr[x][y]=1;
        int fillinnumber=1;
        pair currentpair=new pair(x,y);

        //While pairs is not empty
       while(!pairs.isEmpty())
       {
           System.out.println("\n");
           //removing the pair from the top and setting it to this variable
        currentpair=pairs.pop();
        //Checking North
        if(currentpair.x>0 && arr[currentpair.x-1][currentpair.y]==0)
        {
            //adding new pair ontop of stack for location one north
         pairs.push(new pair(currentpair.x-1, currentpair.y));
        }
        //Checking East
           else if(currentpair.y<9 && arr[currentpair.x][currentpair.y-1]==0)
        {
            //adding new pair ontop of stack for location one north
            pairs.push(new pair(currentpair.x, currentpair.y-1));
        }
        //pairs.push(new pair(currentpair.x-1,currentpair.y));
           //Filling in number
        arr[currentpair.getX()][currentpair.getY()]=fillinnumber;
           //adding one to fillinnumber so number increases with each fill
           fillinnumber++;

        display(arr);
           System.out.println("\n");

       }

    }
    public static void main(String[] args)
    {
        start();
    }
}
