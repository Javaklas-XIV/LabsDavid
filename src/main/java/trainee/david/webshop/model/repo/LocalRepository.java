package trainee.david.webshop.model.repo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class LocalRepository<T> implements IRepo<T>, Iterable<T> {

    protected final List<T> items;

    public LocalRepository() {
        items = new ArrayList<>();
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<>() {
            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < items.size();
            }

            @Override
            public T next() {
                return items.get(index++);
            }
        };
    }

    @Override
    public List<T> getAll() {
        return items;
    }

    @Override
    public T get(int index) {
        return items.get(index);
    }

    @Override
    public void add(T newItem) {
        items.add(newItem);
    }

    @Override
    public boolean remove(T item) {
        return items.remove(item);
    }

    @Override
    public boolean remove(int index) {
        try {
            return items.remove(index) != null;
        } catch (IndexOutOfBoundsException i){
            System.out.println("Cannot remove item at index " + index + ". Index is out of bounds");
            return false;
        }
    }
}
