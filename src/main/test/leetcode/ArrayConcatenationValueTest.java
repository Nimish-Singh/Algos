package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArrayConcatenationValueTest {
    private final ArrayConcatenationValue acv = new ArrayConcatenationValue();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{7, 52, 2, 4};
        assertEquals(596, acv.findTheArrayConcVal(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{5, 14, 13, 8, 12};
        assertEquals(673, acv.findTheArrayConcVal(nums));
    }
}
