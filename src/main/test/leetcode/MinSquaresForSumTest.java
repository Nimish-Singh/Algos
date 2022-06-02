package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinSquaresForSumTest {
    private MinSquaresForSum mss = new MinSquaresForSum();

    @Test
    public void sampleInput1() {
        assertEquals(3, mss.numSquares(12));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, mss.numSquares(2));
    }

    @Test
    public void sampleInput3() {
        assertEquals(2, mss.numSquares(2));
    }

    @Test
    public void sampleInput4() {
        assertEquals(4, mss.numSquares(47));
    }
}
