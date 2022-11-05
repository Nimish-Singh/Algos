package blind75.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class NumberOf1BitsTest {
    private final NumberOf1Bits num = new NumberOf1Bits();

    @Test
    public void sampleInput1() {
        assertEquals(3, num.hammingWeight(11));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1, num.hammingWeight(128));
    }

    @Test
    public void sampleInput3() {
        assertEquals(31, num.hammingWeight(-3));
    }
}
