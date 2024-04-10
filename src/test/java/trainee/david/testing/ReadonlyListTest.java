package trainee.david.testing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ReadonlyListTest {

    private ReadonlyList<Integer> emptyTarget;
    private ReadonlyList<Integer> target;

    @BeforeEach
    void setUp(){
        emptyTarget = new Nil<>();
        target = new Cons<>(1, new Nil<>());
    }

    @Test
    public void length_emptyList_is0() {
        assertEquals(0, emptyTarget.length());
    }

    @Test
    public void contains_emptyList_false(){
        assertFalse(emptyTarget.contains(0));
    }

    @Test
    public void length_consList_is1(){
        assertEquals(1, target.length());
    }

    @Test
    public void length_add1ToList_is2(){
        ReadonlyList<Integer> result = target.add(2);
        assertEquals(2, result.length());
    }

    @Test
    public void contains1_consList_isTrue(){
        assertTrue(target.contains(1));
    }

}