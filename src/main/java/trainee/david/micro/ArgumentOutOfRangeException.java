package trainee.david.micro;

public class ArgumentOutOfRangeException extends Exception{

    private final int argument, min, max;

    public ArgumentOutOfRangeException(int argument, int min, int max){
        this.argument = argument;
        this.min = min;
        this.max = max;
    }

    @Override
    public String getMessage() {
        return "Argument '%d' is out of range (%d - %d)".formatted(argument, min, max);
    }
}
