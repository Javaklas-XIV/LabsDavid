package trainee.david.other.H11;

import trainee.david.other.H7.Person;
import trainee.david.other.H7.PersonDiedException;

public class Main {

    public static void main(String[] args) throws PersonDiedException {
        Person testPerson = new Person("David", 24);
        testPerson.addHistory("Some stuff happened");
        testPerson.addHistory("Other stuff also happened");
        testPerson.printHistory();

        System.out.println(testPerson.createSubHuman().greet());
    }

}
