import java.util.*;

public class ShoppingCart {

    private ArrayList<ItemOrder> orders;

    public ShoppingCart() {

        this.orders = new ArrayList<ItemOrder>();
    }

    public void add(ItemOrder newOrder) {

        for(int i = 0; i < orders.size(); i++) {

            ItemOrder existingOrder = orders.get(i);

            if (existingOrder.getItem() == newOrder.getItem()) {

                orders.remove(i);
                break;
            }
        }

        orders.add(newOrder);
    }

    private boolean discount;

    public void setDiscount(boolean value) {
        this.discount = value;
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < orders.size(); i++) {

            total += orders.get(i).getPrice();
        }

        if (discount) {
            
            total *= 0.9;
            return total;

        } else {

            return total;
        }
    }


}
