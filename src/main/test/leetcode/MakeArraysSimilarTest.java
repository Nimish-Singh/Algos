package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MakeArraysSimilarTest {
    private final MakeArraysSimilar m = new MakeArraysSimilar();
    private int[] nums;
    private int[] target;

    @Test
    public void sampleInput1() {
        nums = new int[]{8, 12, 6};
        target = new int[]{2, 14, 10};
        assertEquals(2, m.makeSimilar(nums, target));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, 2, 5};
        target = new int[]{4, 1, 3};
        assertEquals(1, m.makeSimilar(nums, target));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{1, 1, 1, 1, 1};
        target = new int[]{1, 1, 1, 1, 1};
        assertEquals(0, m.makeSimilar(nums, target));
    }
}
