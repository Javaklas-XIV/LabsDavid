package trainee.david.other;

import java.lang.reflect.*;
import java.util.ArrayList;
import java.util.List;

public class H8 {

    public static void run() throws PersonDiedException {
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

        Method[] methods = alice.getClass().getMethods();
        for (Method method : methods) System.out.println("Method: " + method.getName());
    }

}
