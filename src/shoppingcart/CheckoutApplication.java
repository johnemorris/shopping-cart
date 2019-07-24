package shoppingcart;

import java.util.Scanner;

/**
 *
 * @author John Morris
 */
public class CheckoutApplication {
    private final static double BUY_ONE_GET_ONE = 0.5;
    private final static double THREE_FOR_TWO = 0.6;


    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Get the list of products and process
        // Making the following assumptions for brevity:
        // - Only Apple and Orange are applicable (case-sensitive)ple
        //
        String[] items = getUserInput();
        if (items.length != 0) {
            // Making assumption that items entered are only Apple or Orange. Otherwise, I would validate here
            cart.setItems(items);
            // Apply any sales that are currently available
            cart.setAppleSaleAdjustment(BUY_ONE_GET_ONE);
            cart.setOrangeSalesAdjustment(THREE_FOR_TWO);
            // Determine the total cost
            cart.processCart();
         }
        System.out.println("Total cost is: " + cart.getTotalSale());
    }


    /*
    Private methods
     */
    private static String[] getUserInput(){
        Scanner in  = new Scanner(System.in);
        System.out.println("Enter the list of item, separated by comma (Apple, Orange, Orange,...): ");
        String userInput = in.nextLine();
        String[] items = userInput.split("\\s*,\\s*");
        return items;
    }


}
