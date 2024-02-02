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
        Stack<Integer> driveway = new Stack<Integer>();
        Stack<Integer> street = new Stack<Integer>();
        driveway.push(1);
        driveway.push(7);
        driveway.push(4);
        int menu = 1;
        while (menu != 0) {
            System.out.println("Please enter a car number to add or remove to the driveway.");
            menu = input.nextInt();

            if(menu>0)
            {
                driveway.push(menu);
                System.out.println("\nCars in driveway" + driveway);
                System.out.println("Cars in street" + street);
            }
            if(menu==0)
            {
                break;
            }
            if(menu<0)
            {
                menu=menu*-1;
                boolean finished = false;
                while(finished==false)
                {
                    if(menu!=driveway.peek())
                    {
                        street.push(driveway.pop());
                        System.out.println("\nCars in driveway" + driveway);
                        System.out.println("Cars in street" + street);
                    }
                    else if(menu==driveway.peek())
                    {
                        System.out.println("Running Final remove");
                        driveway.pop();
                        finished=true;
                        System.out.println("\nCars in driveway" + driveway);
                        System.out.println("Cars in street" + street);
                    }
                }
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