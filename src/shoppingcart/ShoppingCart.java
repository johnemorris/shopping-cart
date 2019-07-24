package shoppingcart;

import java.util.HashMap;
import java.util.Map;

public class ShoppingCart {

    private final double COST_OF_APPLE = 60;
    private final double COST_OF_ORANGE = 25;
    private final String POUND = "\u00A3";

    private int totalSale;
    private String[] items;
    private double appleSaleAdjustment = 1.0;
    private double orangeSalesAdjustment = 1.0;


    public void processCart(){

        // If cart is empty then do nothing and return
        if (items.length == 0){
            System.out.println("The shopping cvart is empty.");
            return;
        }

        // Loop through items and total the quantities
        Map <String,Integer> quantities = new HashMap<String,Integer>();
        for (String item: items){

            if ( ! (item.equals("Apple") || item.equals("Orange")) ) {
                continue;
            }
            if (quantities.containsKey(item)) {
                int newTotal = quantities.get(item) + 1;
                quantities.put(item, newTotal);
            } else {
                quantities.put(item, 1);
            }

        }
        calculateCost(quantities);
    }

    /*
    Cost returned in British pence
     */
    private void calculateCost(Map<String,Integer> quantities) {
        totalSale = 0;
        if (quantities.containsKey("Apple")){
            totalSale += Math.ceil(quantities.get("Apple") * appleSaleAdjustment) * COST_OF_APPLE;
        }
        if (quantities.containsKey("Orange")){
            totalSale += Math.ceil(quantities.get("Orange") * orangeSalesAdjustment) * COST_OF_ORANGE;
        }
    }


    public void setItems(String[] items) {
        this.items = items;
    }


    public String getTotalSale() {
        // Problem is in British Pounds so need to convert
        int britishPounds = totalSale/100;
        int britishPence = totalSale%100;
        if (britishPounds > 0) {
            return POUND + britishPounds + "."+ String.format("%02d", britishPence);
        }
        return britishPence+"p";
    }

    public void setAppleSaleAdjustment(double appleSaleAdjustment) {
        this.appleSaleAdjustment = appleSaleAdjustment;
    }

    public void setOrangeSalesAdjustment(double orangeSalesAdjustment) {
        this.orangeSalesAdjustment = orangeSalesAdjustment;
    }
}
