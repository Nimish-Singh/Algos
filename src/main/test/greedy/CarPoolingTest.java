package greedy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CarPoolingTest {
    private final CarPooling cp = new CarPooling();
    private int[][] trips;

    @Test
    public void sampleInput1() {
        trips = new int[][]{{2, 1, 5},
                            {3, 3, 7}};
        assertFalse(cp.carPooling(trips, 4));
    }

    @Test
    public void sampleInput2() {
        trips = new int[][]{{2, 1, 5},
                            {3, 3, 7}};
        assertTrue(cp.carPooling(trips, 5));
    }

    @Test
    public void sampleInput3() {
        trips = new int[][]{{3, 6, 9},
                            {10, 2, 3},
                            {1, 6, 8},
                            {2, 1, 6},
                            {9, 3, 9}};
        assertFalse(cp.carPooling(trips, 12));
    }
}
