import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class LargestDecreasingSubarrayTest {

    @Test
    public void testLargestDecreasingSubarray() {
        assertArrayEquals(new int[]{}, LargestDecreasingSubarray.largestDecreasingSubarray(new int[]{}));
        assertArrayEquals(new int[]{1}, LargestDecreasingSubarray.largestDecreasingSubarray(new int[]{1}));
        assertArrayEquals(new int[]{1}, LargestDecreasingSubarray.largestDecreasingSubarray(new int[]{1, 2}));
        assertArrayEquals(new int[]{2, 1}, LargestDecreasingSubarray.largestDecreasingSubarray(new int[]{2, 1}));
        assertArrayEquals(new int[]{3, 2}, LargestDecreasingSubarray.largestDecreasingSubarray(new int[]{1, 3, 2}));
        assertArrayEquals(new int[]{5, 4, 3, 2}, LargestDecreasingSubarray.largestDecreasingSubarray(new int[]{1, 3, 2, 5, 4, 3, 2, 4}));
        assertArrayEquals(new int[]{6, 3}, LargestDecreasingSubarray.largestDecreasingSubarray(new int[]{5, 6, 3, 5, 7, 8, 9, 1, 2}));
    }
}