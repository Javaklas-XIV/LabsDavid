package trainee.david.other.H12;

import trainee.david.other.H7.Person;
import trainee.david.other.H7.PersonDiedException;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class Main {

    public static void main(String[] args) throws PersonDiedException, NoSuchMethodException {
        Class<Person> personClass = Person.class;
        System.out.println("\tClass annotations: ");
        for (Annotation annotation : personClass.getDeclaredAnnotations()){
            System.out.println(annotation);
        }

        System.out.println("\tMethod annotations: ");
        for (Method method : personClass.getDeclaredMethods()){
            for (Annotation annotation : method.getAnnotations()){
                System.out.println(annotation);
            }
        }
    }

}
