package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UglyNumber2Test {
    private UglyNumber2 ug = new UglyNumber2();

    @Test
    public void sampleInput1() {
        assertEquals(12, ug.nthUglyNumber(10));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1, ug.nthUglyNumber(1));
    }

    @Test
    public void sampleInput3() {
        assertEquals(15, ug.nthUglyNumber(11));
    }

    @Test
    public void sampleInput4() {
        assertEquals(24, ug.nthUglyNumber(15));
    }
}
