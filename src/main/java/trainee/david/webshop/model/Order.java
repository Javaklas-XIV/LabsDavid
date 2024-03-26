package trainee.david.webshop.model;

import java.math.BigDecimal;
import java.util.*;

public class Order {

    private final Calendar orderDate;
    private final Map<Item, Integer> orderedItems;
    private BigDecimal totalPrice;

    public Order(Calendar orderDate) {
        this.orderDate = orderDate;
        orderedItems = new HashMap<>();
        totalPrice = BigDecimal.ZERO;
    }

    public void addItem(Item newItem) {
        orderedItems.put(newItem, orderedItems.containsKey(newItem) ? orderedItems.get(newItem) + 1 : 1);
        totalPrice = totalPrice.add(newItem.getPrice());
    }

    public void removeItem(int id) {
        orderedItems.forEach((item, integer) -> {
            if(item.getId() == id){
                if (integer > 1) orderedItems.replace(item, integer - 1);
                else {
                    orderedItems.remove(item);
                }
            }
        });
    }

    public Map<Item, Integer> getItems() {
        return orderedItems;
    }

    public double getTotalPrice() {
        return totalPrice.doubleValue();
    }

    public Calendar getOrderDate() {
        return orderDate;
    }

    @Override
    public String toString() {
        return "[%d-%d] %d articles with a total price of €%.2f".formatted(
                orderDate.get(Calendar.DAY_OF_MONTH),
                orderDate.get(Calendar.MONTH),
                orderedItems.size(),
                getTotalPrice());
    }
}
