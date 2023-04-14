package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class EvenOddBItCountTest {
    private final EvenOddBItCount eo = new EvenOddBItCount();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new int[]{2, 0}, eo.evenOddBit(17));
    }

    @Test
    public void sampleInput2() {
        assertArrayEquals(new int[]{0, 1}, eo.evenOddBit(2));
    }
}
