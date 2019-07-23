package shoppingcart;

import java.util.Scanner;

/**
 *
 * @author John Morris
 */
public class CheckoutApplication {

    public static void main(String[] args) {

        ShoppingCart cart = new ShoppingCart();

        // Get the list of products and process
        // Making the following assumptions for brevity:
        // - Only Apple and Orange are applicable (case-sensitive)ple
        //
        String[] items = getUserInput();
        int totalCost = 0;
        if (items.length != 0) {
            // Making assumption that items entered are only Apple or Orange. Otherwise, I would validate here
            cart.setItems(items);
            cart.processCart();
            totalCost = cart.getTotalSale();
         }

        System.out.println("Total cost is: " + totalCost + "p");
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
