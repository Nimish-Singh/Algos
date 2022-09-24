package blind75.array;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class TwoSumTest {
    private final TwoSum twoSum = new TwoSum();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(new int[]{2, 7, 11, 15}, 9));
    }

    @Test
    public void sampleInput2() {
        assertArrayEquals(new int[]{1, 2}, twoSum.twoSum(new int[]{3, 2, 4}, 6));
    }

    @Test
    public void sampleInput3() {
        assertArrayEquals(new int[]{0, 1}, twoSum.twoSum(new int[]{3, 3}, 6));
    }
}
