package trainee.david.webshop.model.repo;

import trainee.david.webshop.model.Order;

import java.util.*;

public class OrderRepo extends LocalRepository<Order> {

    public Optional<Order> findByDate(Calendar orderDate){
        return items.stream().filter(order -> order.getOrderDate().equals(orderDate)).findFirst();
    }
}
