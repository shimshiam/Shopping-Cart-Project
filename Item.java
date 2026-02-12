import java.text.NumberFormat;

// Represents an item that can be purchased, including its name, price, and optional bulk pricing information
public class Item { //
    private String name;
    private double price;
    private int bulkQty;
    private double bulkPrice;

    // Constructor for items that do not have a bulk price
    public Item(String name, double price) {

        if (price < 0){
            throw new IllegalArgumentException("ERROR: Price is negative");
        }

        this.name = name;
        this.price = price;
        bulkQty = 0;
        bulkPrice = 0.0;

        }
    
    // Constructor for items that have a bulk price
    public Item(String name, double price, int bulkQty, double bulkPrice) {

        if (price < 0 || bulkPrice < 0 || bulkQty <0){
            throw new IllegalArgumentException();
        }

        this.name = name;
        this.price  = price;
        this.bulkPrice = bulkPrice;
        this.bulkQty = bulkQty;
    }

    // Returns the price for the given quantity of this item
    public double priceFor(int quantity){ 
        
        if (quantity < 0){
            throw new IllegalArgumentException();
        }

        // If the quantity is greater than or equal to the bulk quantity, then we can apply the bulk price to as 
        // many full packages as possible, and then apply the regular price to any remaining items
        if (bulkQty > 0 && quantity >= bulkQty){
            int pkg = quantity / bulkQty;
            int remainder = quantity % bulkQty;
            return pkg * bulkPrice + remainder * price;
        }
        else {
            return quantity * price; // Otherwise, we just apply the regular price to all items

        }
    }

    // Returns a string representation of this item, including the bulk price if it exists
    public String toString(){

        NumberFormat format = NumberFormat.getCurrencyInstance(); // Format the price as currency
        String output = name + ", " + format.format(price);

        if (bulkQty > 0){ // If there is a bulk price, include it in the string representation
            output += " (" + bulkQty + " for " + format.format(bulkPrice) + ")";
        }

        return output;
    }

}
