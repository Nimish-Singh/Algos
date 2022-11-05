package blind75.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CountBitsTest {
    private final CountBits count = new CountBits();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new int[]{0, 1, 1}, count.countBits(2));
    }

    @Test
    public void sampleInput2() {
        assertArrayEquals(new int[]{0, 1, 1, 2, 1, 2}, count.countBits(5));
    }
}
