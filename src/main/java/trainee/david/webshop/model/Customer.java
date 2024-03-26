package trainee.david.webshop.model;

import java.util.ArrayList;
import java.util.List;

public class Customer {

    private final String name, placeOfResidence;
    private final List<Order> orders;
    private final int id;

    public Customer(int id, String name, String placeOfResidence){
        this.id = id;
        this.name = name;
        this.placeOfResidence = placeOfResidence;
        orders = new ArrayList<>();
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPlaceOfResidence() {
        return placeOfResidence;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void addOrder(Order newOrder){
        orders.add(newOrder);
    }

    @Override
    public String toString() {
        return "[%d] %s - %s".formatted(id, name, placeOfResidence);
    }
}
