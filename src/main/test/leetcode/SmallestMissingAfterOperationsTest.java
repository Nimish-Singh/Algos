package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SmallestMissingAfterOperationsTest {
    private final SmallestMissingAfterOperations smallest = new SmallestMissingAfterOperations();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, -10, 7, 13, 6, 8};
        assertEquals(4, smallest.findSmallestInteger(nums, 5));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, -10, 7, 13, 6, 8};
        assertEquals(2, smallest.findSmallestInteger(nums, 7));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{3, 0, 3, 2, 4, 2, 1, 1, 0, 4};
        assertEquals(10, smallest.findSmallestInteger(nums, 5));
    }

    @Test
    public void sampleInput4() {
        nums = new int[]{0, -3};
        System.out.println(3 % 4);
        System.out.println(-3 % 4);
        System.out.println(3 % -4);
        System.out.println(-3 % -4);
        assertEquals(2, smallest.findSmallestInteger(nums, 4));
    }
}
