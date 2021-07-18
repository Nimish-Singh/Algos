package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class NextGreaterElementTest {
    private NextGreaterElement element = new NextGreaterElement();

    @Test
    public void sampleInput1_1() {
        int[] nums1 = new int[]{4, 1, 2};
        int[] nums2 = new int[]{1, 3, 4, 2};
        assertArrayEquals(new int[]{-1, 3, -1}, element.nextGreaterElement(nums1, nums2));
    }

    @Test
    public void sampleInput1_2() {
        int[] nums1 = new int[]{2, 4};
        int[] nums2 = new int[]{1, 2, 3, 4};
        assertArrayEquals(new int[]{3, -1}, element.nextGreaterElement(nums1, nums2));
    }

    @Test
    public void sampleInput2_1() {
        assertArrayEquals(new int[]{2, -1, 2}, element.nextGreaterElements(new int[] {1, 2 ,1}));
    }

    @Test
    public void sampleInput2_2() {
        assertArrayEquals(new int[]{2, 3, 4, -1, 4}, element.nextGreaterElements(new int[] {1, 2, 3, 4, 3}));
    }
}
