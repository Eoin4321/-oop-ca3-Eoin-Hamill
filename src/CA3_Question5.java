import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/**
 *  Name: Eoin Hamill
 *  Class Group: GD2a
 */

public class CA3_Question5
{

    public static void main(String[] args)
    {
        double profit=0;
        //adding a scanner to take input
        Scanner input = new Scanner(System.in);
        //Creating both the separate queues
        Queue<String> takeoff = new LinkedList<String>();
        Queue<String> landing = new LinkedList<String>();
        boolean on = true;
        while(on)
        {
            System.out.println("\ntype: takeoff flightSymbol - To add a flight to take off\n" +
                    "type: land flightSymbol -  To add a flight to land" +
                    "\ntype: next - to run the software" +
                    "\ntype: quit - to end the software");
            String taken = input.next();
            //If user decides to quit the software turn on to false.
            if(taken.equals("quit"))
            {
                on=false;
                break;
            }
            //If users inputs next
            else if(taken.equals("next"))
            {
                //Checking to see if the priority queue is not empty. If it is empty planes can take off.
                if(!landing.isEmpty())
                {
                    System.out.println("Now landing plane "+landing.poll());
                }
                //
                else if(!takeoff.isEmpty())
                {
                    System.out.println("Now taking off plane "+takeoff.poll());
                }
                //Telling the user the next flight
                if(!landing.isEmpty())
                {
                    System.out.println("The next prioritized flight is landing of plane "+landing.peek());
                }
                else if(!takeoff.isEmpty())
                {
                    System.out.println("The next prioritized flight is take off of plane "+takeoff.peek());
                }
                else if(takeoff.isEmpty()&& landing.isEmpty())
                {
                    System.out.println("No flights due to take off");
                }
            }
            else if(taken.equals("land"))
            {
                landing.add(input.next());
                System.out.println("Added new landing plane to queue");
            }
            else if(taken.equals("takeoff"))
            {
                takeoff.add(input.next());
                System.out.println("Added new takeoff plane to queue");
            }
            else
            {
                System.out.println("Invalid Input.");
            }
        }
    }
}
