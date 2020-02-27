import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;

public class NestedListIteratorTest {

    @Test(expected = NoSuchElementException.class)
    public void testNullList() {
        NestedListIterator<String> iterator = new NestedListIterator<>(null);
        assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test(expected = NoSuchElementException.class)
    public void testEmptyList() {
        NestedListIterator<String> iterator = new NestedListIterator<>(new ArrayList<>());
        assertFalse(iterator.hasNext());
        iterator.next();
    }

    @Test
    public void testOneNestedList() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        input.get(0).add(1);
        input.get(0).add(2);
        input.get(0).add(3);

        NestedListIterator<Integer> iterator = new NestedListIterator<>(input);
        assertTrue(iterator.hasNext());

        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(3, iterator.next().intValue());

        assertFalse(iterator.hasNext());
    }

    @Test
    public void testTwoNestedList() {
        List<List<Integer>> input = new ArrayList<>();
        input.add(new ArrayList<>());
        input.get(0).add(1);
        input.get(0).add(2);
        input.get(0).add(3);
        input.add(new ArrayList<>());
        input.get(1).add(4);
        input.get(1).add(5);

        NestedListIterator<Integer> iterator = new NestedListIterator<>(input);
        assertTrue(iterator.hasNext());

        assertEquals(1, iterator.next().intValue());
        assertEquals(2, iterator.next().intValue());
        assertEquals(3, iterator.next().intValue());

        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next().intValue());
        assertEquals(5, iterator.next().intValue());

        assertFalse(iterator.hasNext());
    }
}