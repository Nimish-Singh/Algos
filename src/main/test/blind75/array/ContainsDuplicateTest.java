package blind75.array;

import blind75.array.ContainsDuplicate;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsDuplicateTest {
    private final ContainsDuplicate duplicate = new ContainsDuplicate();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 2, 3, 1};
        assertTrue(duplicate.containsDuplicate(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, 2, 3, 4};
        assertFalse(duplicate.containsDuplicate(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[]{1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        assertTrue(duplicate.containsDuplicate(nums));
    }
}
