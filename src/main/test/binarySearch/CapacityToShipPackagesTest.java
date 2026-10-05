package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CapacityToShipPackagesTest {
    private final CapacityToShipPackages capacity = new CapacityToShipPackages();
    private int[] weights;

    @Test
    public void sampleInput1() {
        weights = new int[]{3, 2, 2, 4, 1, 4};
        assertEquals(6, capacity.shipWithinDays(weights, 3));
    }

    @Test
    public void sampleInput2() {
        weights = new int[]{1, 2, 3, 1, 1};
        assertEquals(3, capacity.shipWithinDays(weights, 4));
    }
}
