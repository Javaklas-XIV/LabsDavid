package trainee.david.other.H13;

import trainee.david.other.H10.Human;

import java.util.ArrayList;
import java.util.List;

public class House<T extends Human> {

    private final List<T> residents;

    public House(){
        residents = new ArrayList<>();
    }

    public void addResident(T newResident){
        residents.add(newResident);
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (T human : residents){
            String resident = "[" + human.toString() + "] and it says [" + human.greet() + "]\n";
            result.append(resident);
        }
        return "This house is owned by " + result;
    }
}
