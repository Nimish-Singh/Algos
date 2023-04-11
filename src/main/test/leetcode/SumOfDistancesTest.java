package leetcode;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class SumOfDistancesTest {
    private final SumOfDistances sum = new SumOfDistances();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 3, 1, 1, 2};
        long[] distance = sum.distance(nums);
        System.out.println(Arrays.toString(distance));
        assertArrayEquals(new long[]{5, 0, 3, 4, 0}, distance);
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{0, 5, 3};
        assertArrayEquals(new long[]{0, 0, 0}, sum.distance(nums));
    }
}
