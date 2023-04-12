package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MinOperationsForEqualTest {
    private final MinOperationsForEqual min = new MinOperationsForEqual();
    private int[] nums;
    private int[] queries;

    @Test
    public void sampleInput1() {
        nums = new int[]{3, 1, 6, 8};
        queries = new int[]{1, 5};
        assertArrayEquals(new long[]{14, 10}, min.minOperations(nums, queries).stream().mapToLong(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{2, 9, 6, 3};
        queries = new int[]{10};
        assertArrayEquals(new long[]{20}, min.minOperations(nums, queries).stream().mapToLong(x -> x).toArray());
    }
}
