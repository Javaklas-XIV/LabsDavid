package trainee.david.testing;

public class MyMath {

    public static int fib(int n) throws IllegalArgumentException {
        if (n < 0) throw new IllegalArgumentException();
        return (n <= 1 ? 1 : fib(n - 1) + fib(n - 2));
    }

}
