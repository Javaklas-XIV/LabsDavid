package trainee.david.webshop.model;

import java.math.BigDecimal;

public class Item {

    private final int id;
    private final String description;
    private final BigDecimal price;

    public Item(int id, String description, double price){
        this.id = id;
        this.description = description;
        this.price = BigDecimal.valueOf(price);
    }

    public int getId(){
        return id;
    }

    public String getDescription(){
        return description;
    }

    public BigDecimal getPrice(){
        return price;
    }

    @Override
    public String toString() {
        return "Item [%d]: %s | €%.2f".formatted(id, description, price.doubleValue());
    }
}
