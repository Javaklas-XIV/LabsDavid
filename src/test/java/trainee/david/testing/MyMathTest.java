package trainee.david.testing;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class MyMathTest {

    @Test
    public void fib_nIs0_is1(){
        int n = 0;

        int result = MyMath.fib(n);

        assertEquals(1, result);
    }

    @Test
    public void fib_nIs1_is1() {
        int n = 1;

        int result = MyMath.fib(n);

        assertEquals(1, result);
    }

    @Test
    public void fib_nIs2_is2() {
        int n = 2;

        int result = MyMath.fib(n);

        assertEquals(2, result);
    }

    @Test
    public void fib_nIs10_is89() {
        int n = 10;

        int result = MyMath.fib(n);

        assertEquals(89, result);
    }

    @Test
    void fib_nIsNegative_throwsExc() {
        int n = -1;

        assertThrows(IllegalArgumentException.class, () -> MyMath.fib(n));
    }

}