import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MedianTwoSortedArraysTest {

    @Test
    public void testMedianTwoSortedArrays() {
        assertEquals(1, MedianTwoSortedArrays.median(new int[] {1}, new int[] {1, 2}), 1e-6);
        assertEquals(1.5, MedianTwoSortedArrays.median(new int[] {1}, new int[] {2}), 1e-6);
        assertEquals(13.5, MedianTwoSortedArrays.median(new int[] {900}, new int[] {10, 13, 14}), 1e-6);
    }
}