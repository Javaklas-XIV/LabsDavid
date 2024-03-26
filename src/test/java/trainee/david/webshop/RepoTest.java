package trainee.david.webshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trainee.david.webshop.model.repo.LocalRepository;

import static org.junit.jupiter.api.Assertions.*;

public class RepoTest {

    private LocalRepository<Integer> target;

    @BeforeEach
    void SetUp() {
        target = new LocalRepository<>();
    }

    @Test
    void testAdd() {
        assertEquals(0, target.getAll().size());

        target.add(42);

        assertEquals(1, target.getAll().size());
        assertEquals(42, target.get(0));
    }

    @Test
    void testRemove() {
        target.add(42);
        assertEquals(1, target.getAll().size());

        boolean result = target.remove(Integer.valueOf(10));
        assertFalse(result);

        result = target.remove(Integer.valueOf(42));
        assertTrue(result);

        assertEquals(0, target.getAll().size());
        target.add(42);

        result = target.remove(10);
        assertFalse(result);

        result = target.remove(0);
        assertTrue(result);
    }

}
