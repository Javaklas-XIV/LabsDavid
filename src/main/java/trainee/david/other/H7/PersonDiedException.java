package trainee.david.other.H7;

public class PersonDiedException extends Exception{

    @Override
    public String getMessage() {
        return "This person has died";
    }
}
