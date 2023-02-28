package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class Merge2DArraysWithSumsTest {
    private final Merge2DArraysWithSums m = new Merge2DArraysWithSums();
    private int[][] nums1;
    private int[][] nums2;

    @Test
    public void sampleInput1() {
        nums1 = new int[][]{{1, 2},
                            {2, 3},
                            {4, 5}};
        nums2 = new int[][]{{1, 4},
                            {3, 2},
                            {4, 1}};
        assertArrayEquals(new int[][]{{1, 6}, {2, 3}, {3, 2}, {4, 6}}, m.mergeArrays(nums1, nums2));
    }

    @Test
    public void sampleInput2() {
        nums1 = new int[][]{{2, 4},
                            {3, 6},
                            {5, 5}};
        nums2 = new int[][]{{1, 3},
                            {4, 3}};
        assertArrayEquals(new int[][]{{1, 3}, {2, 4}, {3, 6}, {4, 3}, {5, 5}}, m.mergeArrays(nums1, nums2));
    }
}
