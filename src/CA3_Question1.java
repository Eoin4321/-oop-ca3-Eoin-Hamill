import java.util.Scanner;
import java.util.Stack;

/**
 *  Name: Eoin Hamill
 *  Class Group: GD2a
 */
public class CA3_Question1
{
    public static void runSimulation() {
        Scanner input = new Scanner(System.in);
        //Setting up stacks
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();
        //Menu is the car number
        int menu = 1;
        while (menu != 0) {
            System.out.println("Please enter a car number to add or remove to the driveway.");
            menu = input.nextInt();

            if(menu>0)
            {
                //Added car to driveway
                driveway.push(menu);
                System.out.println("\nCars in driveway" + driveway);
                System.out.println("Cars in street" + street);
            }
            //Shutting down menu
            if(menu==0)
            {
                break;
            }
            //Removing a car. If its less then 0 as to remove a car you input a - number
            if(menu<0)
            {
                //Setting the input to be positive so its easy to match in the stack
                menu=menu*-1;
                boolean finished = false;
                //A while until the car is removed and the old cars are put back into the driveway
                while(finished==false)
                {
                    //If the car is not the next car in the driveway I move it to the street
                    if(menu!=driveway.peek())
                    {
                        //adding a car to the street.
                        street.push(driveway.pop());
                        System.out.println("\nCars in driveway" + driveway);
                        System.out.println("Cars in street" + street);
                    }
                    //If the car is the next car in the driveway I remove it
                    else if(menu==driveway.peek())
                    {
                        System.out.println("Running Final remove");
                        driveway.pop();
                        finished=true;
                        System.out.println("\nCars in driveway" + driveway);
                        System.out.println("Cars in street" + street);
                    }
                }
                //Moving cars back into the driveway until the street is empty
                System.out.println("Cars moving back into driveway.");
                while(!street.isEmpty())
                {
                    driveway.push(street.pop());
                    System.out.println("\nCars in driveway" + driveway);
                    System.out.println("Cars in street" + street);
                }
            }
        }
    }


    public static void main(String[] args) {
        runSimulation();
    }
}