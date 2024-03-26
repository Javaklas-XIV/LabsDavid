package trainee.david.other;

public class Person {

    public static String universalRights = "All humans are created equal";
    public static int MAXIMUM_AGE = 130;

    public enum Gender {MALE, FEMALE, UNKNOWN}

    private Gender gender;
    private final String name;
    private int age;

    public Person(String name, int age) throws PersonDiedException{
        this.name = name;
        if (age <= 130) this.age = age;
        else throw new PersonDiedException();
        gender = Gender.UNKNOWN;
    }

    public Person(String name, int age, Gender gender) throws PersonDiedException {
        this(name, age);
        this.gender = gender;
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
}
