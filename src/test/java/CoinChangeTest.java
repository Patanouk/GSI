import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CoinChangeTest {

    @Test
    public void test1() {
        assertEquals(4, CoinChange.count(4, new int[] {1, 2, 3}));
        assertEquals(5, CoinChange.count(10, new int[] {2, 5, 3, 6}));
        assertEquals(1, CoinChange.count(0, new int[] {2, 5, 3, 6}));
        assertEquals(0, CoinChange.count(-5, new int[] {2, 5, 3, 6}));
    }
}