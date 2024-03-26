package trainee.david;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trainee.david.other.Person;
import trainee.david.other.PersonDiedException;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private Person p, alice, bob;

    @BeforeEach
    void SetUp(){
        try {
            p = new Person("Jan", 46);
            alice = new Person("Alice", 30, Person.Gender.FEMALE);
            bob = new Person("Bob", 130, Person.Gender.MALE);
        } catch (PersonDiedException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testPerson(){
        try {
            System.out.println(p.getGender());
            p.setGender(Person.Gender.MALE);
            System.out.println(p.getGender());
            p.haveBirthday(); // person gets one year older
            System.out.println(p.getAge());
            System.out.println(Person.universalRights);
        } catch (PersonDiedException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testBirthday(){
        assertEquals(30, alice.getAge());
        try {
            alice.haveBirthday();
            assertEquals(31, alice.getAge());
        } catch (PersonDiedException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testAge(){
        try {
            assertEquals(30, alice.getAge());

            bob.haveBirthday();
            assertEquals(130, bob.getAge());
        } catch (PersonDiedException exception){
            exception.printStackTrace();
        }
    }

    @Test
    void testName(){
        assertEquals("Jan", p.getName());
        assertEquals("Alice", alice.getName());
        assertEquals("Bob", bob.getName());
    }

    @Test
    void testGender(){
        assertEquals(Person.Gender.UNKNOWN, p.getGender());
        assertEquals(Person.Gender.FEMALE, alice.getGender());
        assertEquals(Person.Gender.MALE, bob.getGender());

        alice.setGender(Person.Gender.MALE);
        assertEquals(Person.Gender.MALE, alice.getGender());
    }

}