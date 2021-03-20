package topKElements;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class KthSmallestNumberTest {
    private KthSmallestNumber kthSmallestNumber = new KthSmallestNumber();

    @Test
    public void sampleInput1() {
        assertEquals(5, kthSmallestNumber.find(new int[] {1, 5, 12, 2, 11, 5}, 3));
    }

    @Test
    public void sampleInput2() {
        assertEquals(5, kthSmallestNumber.find(new int[] {1, 5, 12, 2, 11, 5}, 4));
    }

    @Test
    public void sampleInput3() {
        assertEquals(11, kthSmallestNumber.find(new int[] {12, -1, 11, 12, 5}, 3));
    }
}
