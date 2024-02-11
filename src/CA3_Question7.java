import java.util.*;

/**
 *  Name: Eoin Hamill
 *  Class Group: GD2a
 */
public class CA3_Question7
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
        //Setting up Map with company and queue using the Block class i created. This contains qty and price.
        Map<String, Queue<Block>> shares = new TreeMap<>();
        //adding a scanner to take input
        Scanner in = new Scanner(System.in);
        String command="";
        do {
            System.out.print(">");
            System.out.println("Type in buy or sell");
            command = in.next();
            if(command.equalsIgnoreCase("buy"))
            {
                System.out.println("Enter the company you want to buy stocks for");
                String company = in.next();
                System.out.println("Enter amount you want to buy");
                int qty = in.nextInt();
                System.out.println("Enter the price you will be paying");
                double price = in.nextDouble();
                //If shares does not contain the company name I add it.
                if(!shares.containsKey(company))
                {
                    shares.put(company, new LinkedList<>());
                }
                //Adding the block to the company
                shares.get(company).add(new Block(qty, price));

            }
            else if(command.equals("sell"))
            {
                System.out.println("Enter the company you want to sell stocks for");
                String company = in.next();
                System.out.println("Enter amount you want to sell");
                int qty = in.nextInt();
                System.out.println("Enter the price you will be selling");
                double price = in.nextDouble();
                //Checking if the company exists in the Map
                if(shares.containsKey(company)) {
                    boolean selling = true;
                    //A while loop to run while qty is sufficent. It will be turned off if it runs out.
                    while (selling == true) {
                        //If there is blocks remaining it will keep removing them
                        if (!shares.get(company).isEmpty()) {
                            //Adding up the total profit. price sold at-price bought at. Then i remove 1 from the quantity
                            profit = (price - shares.get(company).peek().getPrice()) + (profit);
                            qty = qty - 1;
                            shares.get(company).peek().setQuantity(shares.get(company).peek().getQuantity() - 1);
                        }
                        //If a block runs out of quantity I remove it from the queue
                        if (shares.get(company).peek().getQuantity() == 0) {
                            shares.get(company).poll();
                        }
                        //If the quantity to sell runs out I end the while loop
                        if (qty == 0) {
                            selling = false;
                        }
                        //if the blocks to sell runs out I end the while loop and return the amount unable to be sold
                        if (shares.get(company).isEmpty()) {
                            System.out.println("Remaining " + qty);
                            selling = false;
                        }

                    }
                }

                //Returning the profit made so far
                System.out.println("You made "+profit+" Euro");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }

}
