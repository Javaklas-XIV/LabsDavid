package trainee.david.webshop.model.repo;

import java.util.List;

public interface IRepo<T> {

    List<T> getAll();

    T get(int index);

    void add(T item);

    boolean remove(T item);

    boolean remove(int index);

}
