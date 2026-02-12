public class ItemOrder {

    private Item item;
    private int quantity;

    public ItemOrder(Item item, int quantity){

        this.item = item;
        this.quantity = quantity;
    }

    public double getPrice(){ // returns the price of the order

        double cost = item.priceFor(quantity); // calls the priceFor method to calculate the cost of the order based on the quantity
        return cost;
    }
    
    public Item getItem() { // returns the item in the order
        return item;
    }
}
