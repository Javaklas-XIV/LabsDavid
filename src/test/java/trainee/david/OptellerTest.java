package trainee.david;

import org.junit.jupiter.api.Test;
import trainee.david.other.Opteller;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class OptellerTest {

    @Test
    void TestPositieveInts (){
        int a = 1;
        int b = 2;

        int result = Opteller.som(a, b);

        assertEquals((a + b), result);
    }

}
