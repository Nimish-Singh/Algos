package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinKForMOperationsTest {
    private final MinKForMOperations k = new MinKForMOperations();
    private int[] arr = new int[]{4, 5, 1, 9, 14, 5, 36};

    @Test
    public void sampleInput1() {
        assertEquals(10, k.solve(arr, 4));
    }

    @Test
    public void sampleInput2() {
        assertEquals(6, k.solve(arr, 9));
    }
}
