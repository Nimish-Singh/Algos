package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinimumInRotatedArrayTest {
    private final MinimumInRotatedArray min = new MinimumInRotatedArray();
    private int[] arr;

    @Test
    public void sampleInput1() {
        arr = new int[]{3, 4, 5, 1, 2};
        assertEquals(1, min.findMinimum(arr));
    }

    @Test
    public void sampleInput2() {
        arr = new int[]{4, 5, 6, 7, 0, 1, 2};
        assertEquals(0, min.findMinimum(arr));
    }

    @Test
    public void sampleInput3() {
        arr = new int[]{11, 13, 15, 17};
        assertEquals(11, min.findMinimum(arr));
    }
}
