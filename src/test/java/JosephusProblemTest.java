import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class JosephusProblemTest {

    @Test
    public void JosephusTest() {
        assertEquals(1, JosephusProblem.josephus(new int[]{1}, 2));
        assertEquals(1, JosephusProblem.josephus(new int[]{1, 2}, 2));
        assertEquals(3, JosephusProblem.josephus(new int[]{1, 2, 3}, 2));
        assertEquals(13, JosephusProblem.josephus(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14}, 2));
    }

    @Test
    @Ignore("FIXME : https://www.geeksforgeeks.org/goldman-sachs-interview-experience-for-1-5-years-experienced/")
    public void testGS() {
        assertEquals(2, JosephusProblem.josephus(new int[]{2, 3, 1, 4, 5}, 2));
    }
}