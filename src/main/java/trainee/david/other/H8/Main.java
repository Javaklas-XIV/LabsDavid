package trainee.david.other.H8;

import trainee.david.other.H7.Person;
import trainee.david.other.H7.PersonDiedException;

import java.lang.reflect.*;
import java.security.AlgorithmConstraints;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws PersonDiedException {
        Person alice = new Person("Alice", 20, Person.Gender.FEMALE);
        Person bob = new Person("Bob", 21, Person.Gender.MALE);
        Person aliceTheSecond = new Person("Alice", 20, Person.Gender.FEMALE);

        System.out.println(alice);
        System.out.println("Hash: " + alice.hashCode() + "\n");
        System.out.println(bob);
        System.out.println("Hash: " + bob.hashCode() + "\n");
        System.out.println(aliceTheSecond);
        System.out.println("Hash: " + aliceTheSecond.hashCode() + "\n");

        System.out.println("Alice == Alice? " + alice.equals(aliceTheSecond));
        System.out.println("Alice == Bob? " + alice.equals(bob));

        // Reflection
        System.out.println("\n--- Reflection ---\n");

        Field[] fields = Person.class.getDeclaredFields();
        for (Field field : fields) System.out.println("Field: " + field.getName());

        Method[] methods = alice.getClass().getDeclaredMethods();
        for (Method method : methods) System.out.println("Method: " + method.getName());

        // Set
        System.out.println("\n--- HashSet ---\n");

        Set<Person> people = new HashSet<>();
        people.add(alice);
        people.add(aliceTheSecond);
        for (Person person : people){
            System.out.println(person);
        }

        Set<PersonRecord> peopleRecords = new HashSet<>();
        PersonRecord aliceRecord = new PersonRecord("Alice", 20);
        PersonRecord aliceTheSecondRecord = new PersonRecord("Alice", 20);
        peopleRecords.add(aliceRecord);
        peopleRecords.add(aliceTheSecondRecord);

        for (PersonRecord person : peopleRecords){
            System.out.println(person);
        }
    }

}
