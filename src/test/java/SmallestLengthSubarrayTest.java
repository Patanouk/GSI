import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class SmallestLengthSubarrayTest {

    @Test
    public void testMinSubarrayQuadratic() {
        assertArrayEquals(new int[]{4, 45, 6}, SmallestLengthSubarray.getSmallestSubarrayQuadratic(new int[]{1, 4, 45, 6, 0, 19}, 51));
        assertArrayEquals(new int[]{10}, SmallestLengthSubarray.getSmallestSubarrayQuadratic(new int[]{1, 10, 5, 2, 7}, 9));
        assertArrayEquals(new int[]{100, 1, 0, 200}, SmallestLengthSubarray.getSmallestSubarrayQuadratic(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
        assertArrayEquals(new int[]{}, SmallestLengthSubarray.getSmallestSubarrayQuadratic(new int[]{1, 2, 4}, 8));
    }

    @Test
    public void testMinSubarrayLinear() {
        assertArrayEquals(new int[]{4, 45, 6}, SmallestLengthSubarray.getSmallestSubarrayLinear(new int[]{1, 4, 45, 6, 0, 19}, 51));
        assertArrayEquals(new int[]{10}, SmallestLengthSubarray.getSmallestSubarrayLinear(new int[]{1, 10, 5, 2, 7}, 9));
        assertArrayEquals(new int[]{100, 1, 0, 200}, SmallestLengthSubarray.getSmallestSubarrayLinear(new int[]{1, 11, 100, 1, 0, 200, 3, 2, 1, 250}, 280));
        assertArrayEquals(new int[]{}, SmallestLengthSubarray.getSmallestSubarrayLinear(new int[]{1, 2, 4}, 8));
    }
}