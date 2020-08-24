package binarySearch;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RotatedArrayPivotTest {
    private MinimumInRotatedArray minimumInRotatedArray = new MinimumInRotatedArray();

    @Test
    public void shouldReturnInvalidNumberIfArrayIsNull() {
        assertEquals(Integer.MAX_VALUE, minimumInRotatedArray.findMinimum(null));
    }

    @Test
    public void shouldReturnInvalidNumberIfArrayIsEmpty() {
        assertEquals(Integer.MAX_VALUE, minimumInRotatedArray.findMinimum(new int[]{}));
    }

    @Test
    public void shouldReturnMinimumWhenArrayRotatedTillFirstHalf() {
        assertEquals(0, minimumInRotatedArray.findMinimum(new int[]{4, 5, 0, 1, 2, 3}));
    }

    @Test
    public void shouldReturnMinimumWhenArrayRotatedTillSecondHalf() {
        assertEquals(0, minimumInRotatedArray.findMinimum(new int[]{2, 3, 4, 5, 0, 1}));
    }
}
