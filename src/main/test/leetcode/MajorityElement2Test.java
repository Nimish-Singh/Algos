package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class MajorityElement2Test {
    private MajorityElement2 element = new MajorityElement2();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{3, 2, 3};
        List<Integer> majorityElements = element.majorityElement(nums);
        assertEquals(1, majorityElements.size());
        assertTrue(majorityElements.contains(3));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1};
        List<Integer> majorityElements = element.majorityElement(nums);
        assertEquals(1, majorityElements.size());
        assertTrue(majorityElements.contains(1));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{1, 2};
        List<Integer> majorityElements = element.majorityElement(nums);
        assertEquals(2, majorityElements.size());
        assertTrue(majorityElements.contains(1));
        assertTrue(majorityElements.contains(2));
    }
}
