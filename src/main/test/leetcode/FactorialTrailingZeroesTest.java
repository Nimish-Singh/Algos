package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FactorialTrailingZeroesTest {
    private final FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();

    @Test
    public void sampleInput1() {
        assertEquals(0, ftz.trailingZeroes(3));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1, ftz.trailingZeroes(5));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, ftz.trailingZeroes(0));
    }

    @Test
    public void sampleInput4() {
        assertEquals(2, ftz.trailingZeroes(10));
    }
}
