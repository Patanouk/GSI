import org.junit.Test;

import static org.junit.Assert.assertEquals;

/*
https://www.geeksforgeeks.org/minimum-initial-energy-required-to-cross-street/
 */
public class MinEnergyCrossingTest {

    @Test
    public void testAllPositive() {
        int[] checkpoints = new int[]{1, 2, 3, 4};
        assertEquals(1, MinEnergyCrossing.minEnergy(checkpoints));
    }

    @Test
    public void testMixNegativePositive() {
        int[] checkpoints = {4, -10, 4, 4, 4};
        assertEquals(7, MinEnergyCrossing.minEnergy(checkpoints));
    }

    @Test
    public void testMixNegativePositive2() {
        int[] checkpoints = {3, 5, 2, 6, 1};
        assertEquals(1, MinEnergyCrossing.minEnergy(checkpoints));
    }

    @Test
    public void testAllNegative() {
        int[] checkpoints = {-1, -5, -9};
        assertEquals(16, MinEnergyCrossing.minEnergy(checkpoints));
    }
}