package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UncrossedLinesTest {
    private final UncrossedLines ul = new UncrossedLines();
    private int[] nums1;
    private int[] nums2;

    @Test
    public void sampleInput1() {
        nums1 = new int[]{1, 4, 2};
        nums2 = new int[]{1, 2, 4};
        assertEquals(2, ul.maxUncrossedLines(nums1, nums2));
    }

    @Test
    public void sampleInput2() {
        nums1 = new int[]{2, 5, 1, 2, 5};
        nums2 = new int[]{10, 5, 2, 1, 5, 2};
        assertEquals(3, ul.maxUncrossedLines(nums1, nums2));
    }

    @Test
    public void sampleInput3() {
        nums1 = new int[]{1, 3, 7, 1, 7, 5};
        nums2 = new int[]{1, 9, 2, 5, 1};
        assertEquals(2, ul.maxUncrossedLines(nums1, nums2));
    }
}
