package prefixSum;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class NumArrayTest {
    private NumArray numArray;

    @Test
    public void sampleInput1() {
        int[] arr = new int[]{-2, 0, 3, -5, 2, -1};
        numArray = new NumArray(arr);

        assertEquals(1, numArray.sumRange(0, 2));
        assertEquals(-1, numArray.sumRange(2, 5));
        assertEquals(-3, numArray.sumRange(0, 5));
    }
}
