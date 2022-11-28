package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StringZigzagConversionTest {
    private final StringZigzagConversion s = new StringZigzagConversion();

    @Test
    public void sampleInput1() {
        assertEquals("PAHNAPLSIIGYIR", s.convert("PAYPALISHIRING", 3));
    }

    @Test
    public void sampleInput2() {
        assertEquals("PINALSIGYAHRPI", s.convert("PAYPALISHIRING", 4));
    }

    @Test
    public void sampleInput3() {
        assertEquals("A", s.convert("A", 1));
    }
}
