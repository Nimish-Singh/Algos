package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DecodeWaysTest {
    private DecodeWays dw = new DecodeWays();

    @Test
    public void sampleInput1() {
        assertEquals(2, dw.numDecodings("12"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, dw.numDecodings("226"));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, dw.numDecodings("06"));
    }

    @Test
    public void sampleInput4() {
        assertEquals(5, dw.numDecodings("1221"));
    }

    @Test
    public void sampleInput5() {
        assertEquals(1836311903, dw.numDecodings("111111111111111111111111111111111111111111111"));
    }

    @Test
    public void sampleInput6() {
        assertEquals(1, dw.numDecodings("10"));
    }
}
