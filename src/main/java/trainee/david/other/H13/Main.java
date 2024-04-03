package trainee.david.other.H13;

import trainee.david.other.H7.Person;
import trainee.david.other.H7.PersonDiedException;

public class Main {

    public static void main(String[] args) throws PersonDiedException {
        House<Person> ha = new House<>();

        Person a1 = new Person("Alice", 20);
        Person a2 = new Person("Bob",21);

        ha.addResident(a1);
        ha.addResident(a2);

        System.out.println(ha);

        MyIntCollection<Integer> intCollection = new MyIntCollection<>(Integer.class);
        intCollection.add(1);
        intCollection.add(2);
        intCollection.add(3);
        intCollection.add(4);
        intCollection.add(5);
        intCollection.add(6);
        System.out.println(intCollection);
    }

}
