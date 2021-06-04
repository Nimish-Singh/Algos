package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class Divide2IntegersTest {
    private Divide2Integers divide = new Divide2Integers();

    @Test
    public void sampleInput1() {
        assertEquals(3, divide.divide(10, 3));
    }

    @Test
    public void sampleInput2() {
        assertEquals(-2, divide.divide(7, -3));
    }

    @Test
    public void sampleInput3() {
        assertEquals(0, divide.divide(0, 1));
    }

    @Test
    public void sampleInput4() {
        assertEquals(1, divide.divide(1, 1));
    }
}
