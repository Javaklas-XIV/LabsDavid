package trainee.david.other.H7;

import trainee.david.other.H10.Human;

import java.util.ArrayList;
import java.util.List;

public class Person extends Human {

    public static String universalRights = "All humans are created equal";
    public static int MAXIMUM_AGE = 130;

    public enum Gender {MALE, FEMALE, UNKNOWN}

    private Gender gender;
    private final String name;
    private int age;

    private List<HistoryRecord> history;

    public Person(String name, int age) throws PersonDiedException {
        this.name = name;
        if (age <= 130) this.age = age;
        else throw new PersonDiedException();
        gender = Gender.UNKNOWN;
        history = new ArrayList<>();
    }

    public Person(String name, int age, Gender gender) throws PersonDiedException {
        this(name, age);
        this.gender = gender;
    }

    @Override
    public String greet() {
        return "Hello, my name is %s. Nice to meet you!".formatted(name);
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Gender getGender() {
        return gender;
    }

    public void haveBirthday() throws PersonDiedException{
        if (age + 1 > MAXIMUM_AGE) throw new PersonDiedException();
        age++;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Person other){
            return other.name.equals(name) && other.age == age && other.gender == gender;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return age * name.hashCode() * gender.hashCode();
    }

    @Override
    public String toString() {
        return "%s (%d) is %s".formatted(name, age, gender);
    }

    public Human createSubHuman(){
        return new Human() {
            @Override
            public String greet() {
                return "Sub is the best.";
            }
        };
    }

    public void addHistory(String description){
        history.add(new HistoryRecord(description));
    }

    public void printHistory(){
        for (HistoryRecord hr : history){
            System.out.println(hr);
        }
    }

    private class HistoryRecord {
        private final String description;

        public HistoryRecord(String description){
            this.description = description;
        }

        @Override
        public String toString() {
            return description;
        }
    }
}
