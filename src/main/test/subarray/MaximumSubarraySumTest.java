package subarray;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MaximumSubarraySumTest {
    private MaximumSubarraySum maxSumSubarray = new MaximumSubarraySum();

    @Test
    public void shouldReturnMaxWithArrayOfSize1() {
        int[] array = {4};
        SubarrayResult result = this.maxSumSubarray.findMaxSumSubarray(array, 0, array.length - 1);
        assertEquals(4, result.getSum());
        assertEquals(0, result.getLowerIndex());
        assertEquals(0, result.getHigherIndex());
    }

    @Test
    public void shouldReturnMaxWithArrayOfAllPositiveNumbers() {
        int[] array = {1, 2, 3, 4, 5};
        SubarrayResult result = this.maxSumSubarray.findMaxSumSubarray(array, 0, array.length - 1);
        assertEquals(15, result.getSum());
        assertEquals(0, result.getLowerIndex());
        assertEquals(4, result.getHigherIndex());
    }

    @Test
    public void shouldReturnMaxWithArrayOfAllNegativeNumbers() {
        int[] array = {-5, -2, -3, -4, -5};
        SubarrayResult result = this.maxSumSubarray.findMaxSumSubarray(array, 0, array.length - 1);
        assertEquals(-2, result.getSum());
        assertEquals(1, result.getLowerIndex());
        assertEquals(1, result.getHigherIndex());
    }

    @Test
    public void shouldReturnMaxWithArrayOfMixedNumbers() {
        int[] array = {-5, -2, 3, 4, -5, 10, 1, -5, -6, 1, 8, -19};
        SubarrayResult result = this.maxSumSubarray.findMaxSumSubarray(array, 0, array.length - 1);
        assertEquals(13, result.getSum());
        assertEquals(2, result.getLowerIndex());
        assertEquals(6, result.getHigherIndex());
    }
}