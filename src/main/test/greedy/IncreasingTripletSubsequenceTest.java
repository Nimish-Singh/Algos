package greedy;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class IncreasingTripletSubsequenceTest {
    private final IncreasingTripletSubsequence subsequence = new IncreasingTripletSubsequence();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 3, 4, 5};
        assertTrue(subsequence.increasingTriplet(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{5, 4, 3, 2, 1};
        assertFalse(subsequence.increasingTriplet(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{2, 1, 5, 0, 4, 6};
        assertTrue(subsequence.increasingTriplet(nums));
    }
}
