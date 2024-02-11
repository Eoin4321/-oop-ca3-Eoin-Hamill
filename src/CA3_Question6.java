import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
/**
 *  Name: Eoin
 *  Class Group: Hamill
 */
public class CA3_Question6
{

    /*
    Will repeatedly ask the user to enter the commands in the format
    buy qty price
    or
    sell qty price
    or
    quit
     */
    public static void main(String[] args) {
        //Setting up variables
        double profit=0;
        //Setting up queue using the Block class i created. This contains qty and price.
        Queue<Block> blocks = new LinkedList<>();
        //adding a scanner to take input
       Scanner in = new Scanner(System.in);
        String command="";
            do {
            System.out.print(">");
                System.out.println("Type in buy or sell");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                System.out.println("Enter amount you want to buy");
                int qty = in.nextInt();
                System.out.println("Enter the price you will be paying");
                double price = in.nextDouble();
                //Adding the inputs to the queue
                blocks.add(new Block(qty, price));

            }
            else if(command.equals("sell"))
            {
                System.out.println("Enter amount you want to sell");
                int qty = in.nextInt();
                System.out.println("Enter the price you will be paying");
                double price = in.nextDouble();
                boolean selling = true;
                //A while loop to run while qty is sufficent. It will be turned off if it runs out.
                while(selling==true)
                {
                    //If there is blocks remaining it will keep removing them
                    if(!blocks.isEmpty()) {
                        //Adding up the total profit. price sold at-price bought at. Then i remove 1 from the quantity
                        profit = (price - blocks.peek().getPrice()) + (profit);
                        qty = qty - 1;
                        blocks.peek().setQuantity(blocks.peek().getQuantity() - 1);
                    }
                    //If a block runs out of quantity I remove it from the queue
                    if(blocks.peek().getQuantity()==0)
                    {
                        blocks.poll();
                    }
                    //If the quantity to sell runs out I end the while loop
                    if(qty==0)
                    {
                        selling=false;
                    }
                    //if the blocks to sell runs out I end the while loop and return the amount unable to be sold
                    if(blocks.isEmpty())
                    {
                        System.out.println("Amount unable to be sold: "+qty);
                        selling=false;
                    }

                }

                //Returning the profit made so far
                System.out.println("You made "+profit+" Euro");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }

    }
