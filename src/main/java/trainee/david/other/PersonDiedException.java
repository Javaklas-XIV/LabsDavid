package trainee.david.other;

public class PersonDiedException extends Exception{

    @Override
    public String getMessage() {
        return "This person has died";
    }
}
