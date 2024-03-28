package trainee.david.other.H10;

import trainee.david.other.H7.Person;
import trainee.david.other.H7.PersonDiedException;

public class Employee extends Person {

    public Employee(String name, int age) throws PersonDiedException {
        super(name, age);
    }

    @Override
    public String greet() {
        return "I'm tired of working. This is inhuman!";
    }
}
