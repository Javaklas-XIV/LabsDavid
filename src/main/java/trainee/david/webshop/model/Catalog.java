package trainee.david.webshop.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Catalog implements Iterable<Item> {

    private final List<Item> catalogItems;
    private final int year;

    public Catalog(int year){
        this.year = year;
        catalogItems = new ArrayList<>();
    }

    @Override
    public Iterator<Item> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < catalogItems.size();
            }

            @Override
            public Item next() {
                return catalogItems.get(index++);
            }
        };
    }

    public int getYear() {
        return year;
    }

    public void addItem(String description, double price){
        catalogItems.add(new Item(catalogItems.size() + 1, description, price));
    }

    public void addItem(Item newItem){
        catalogItems.add(newItem);
    }

    public Item[] articles(){
        return catalogItems.toArray(new Item[0]);
    }

    public Item get(int id){
        for (Item item : catalogItems){
            if (item.getId() == id) return item;
        }
        return null;
    }

    @Override
    public String toString() {
        return "[%d] Contains %d articles".formatted(year, catalogItems.size());
    }
}
