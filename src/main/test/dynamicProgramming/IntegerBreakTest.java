package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class IntegerBreakTest {
    private final IntegerBreak integerBreak = new IntegerBreak();

    @Test
    public void sampleInput1() {
        assertEquals(1, integerBreak.integerBreak(2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, integerBreak.integerBreak(3));
    }

    @Test
    public void sampleInput3() {
        assertEquals(36, integerBreak.integerBreak(10));
    }
}
