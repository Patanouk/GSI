import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackGetMinTest {

    @Test
    public void testStackGetMin() {
        StackGetMin s = new StackGetMin();
        s.push(3);
        s.push(5);
        assertEquals(3, s.getMin());

        s.push(2);
        s.push(1);
        assertEquals(1, s.getMin());

        assertEquals(1, s.pop());
        assertEquals(2, s.getMin());
        assertEquals(2, s.pop());
        assertEquals(3, s.getMin());
    }
}