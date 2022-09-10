package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ArraySizeToHalfTest {
    private final ArraySizeToHalf size = new ArraySizeToHalf();
    private int[] arr;

    @Test
    public void sampleInput1() {
        arr = new int[]{3, 3, 3, 3, 5, 5, 5, 2, 2, 7};
        assertEquals(2, size.minSetSize(arr));
    }

    @Test
    public void sampleInput2() {
        arr = new int[]{7, 7, 7, 7, 7, 7};
        assertEquals(1, size.minSetSize(arr));
    }
}
