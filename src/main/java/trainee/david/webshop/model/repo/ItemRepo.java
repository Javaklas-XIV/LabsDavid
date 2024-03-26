package trainee.david.webshop.model.repo;

import trainee.david.webshop.model.Item;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class ItemRepo extends LocalRepository<Item> {

    public ItemRepo(){
        // TEMP
        int itemId = 0;
        Item item1 = new Item(itemId++, "Geweldig ding", 56.78);
        Item item2 = new Item(itemId++, "Middelmatig ding", 12.34);
        Item item3 = new Item(itemId++, "Slecht ding", 1.99);
        items.addAll(List.of(item1, item2, item3));
    }

    public Optional<Item> find(String query) {
        return items.stream().filter(item -> item.getDescription().contains(query)).findFirst();
    }

    public Optional<Item> find(int id){
        return items.stream().filter(item -> item.getId() == id).findFirst();
    }
}
