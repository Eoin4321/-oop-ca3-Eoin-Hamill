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
        //Setting up queue using the Block class i created. This contains qty and price.
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
                if(!shares.containsKey(company))
                {
                    shares.put(company, new LinkedList<>());
                }
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
                if(shares.containsKey(company)) {
                    boolean selling = true;
                    while (selling == true) {
                        if (!shares.get(company).isEmpty()) {
                            profit = (price - shares.get(company).peek().getPrice()) + (profit);
                            qty = qty - 1;
                            shares.get(company).peek().setQuantity(shares.get(company).peek().getQuantity() - 1);
                        }
                        if (shares.get(company).peek().getQuantity() == 0) {
                            shares.get(company).poll();
                        }
                        if (qty == 0) {
                            selling = false;
                        }
                        if (shares.get(company).isEmpty()) {
                            System.out.println("Remaining " + qty);
                            selling = false;
                        }

                    }
                }
                //profit=(profit+((blocks.peek().getQuantity()*price)-(blocks.peek().getQuantity()*blocks.peek().getPrice())));

                System.out.println("You made "+profit+" Euro");
            }
        }while(!command.equalsIgnoreCase("quit"));
    }

}
