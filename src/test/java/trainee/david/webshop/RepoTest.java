package trainee.david.webshop;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import trainee.david.webshop.model.Item;
import trainee.david.webshop.model.repo.ItemRepo;
import trainee.david.webshop.model.repo.LocalRepository;

import static org.junit.jupiter.api.Assertions.*;

public class RepoTest {

    private LocalRepository<Item> target;

    @BeforeEach
    void SetUp() {
        target = new ItemRepo();
    }

    @Test
    void testAdd() {
        assertEquals(3, target.getAll().size());

        target.add(new Item(1, "desc", 12.34));

        assertEquals(4, target.getAll().size());
        assertEquals(1, target.get(1).getId());
    }

    @Test
    void testRemove() {
        assertEquals(3, target.getAll().size());

        boolean result = target.remove(10);
        assertFalse(result);

        result = target.remove(0);
        assertTrue(result);

        assertEquals(2, target.getAll().size());
    }

}
