package trainee.david.other.H13;

import java.lang.reflect.Array;
import java.util.List;

public class MyIntCollection<T> {

    private final Class<T> tClass;
    private T[] list;
    private int size;

    public MyIntCollection(Class<T> tClass){
        this.tClass = tClass;
//        list = new T[4];
        list = (T[]) Array.newInstance(tClass, 4);
        size = 0;
    }

    public void add(T number){
        if (size == list.length) doubleArraySize();
        list[size++] = number;
    }

    private void doubleArraySize(){
        T[] old = list.clone();
//        list = new T[size * 2];
        list = (T[]) Array.newInstance(tClass, size * 2);
        System.arraycopy(old, 0, list, 0, old.length);
    }

    public <I> void copy(List<I> from, List<? super I> to){
        to.addAll(from);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (int index = 0; index < size; index++){
            result.append(list[index]);
            if (index != size - 1) result.append(", ");
        }
        return "[" + result + "]";
    }
}
