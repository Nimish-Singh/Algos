package blind75.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SumOfTwoIntegersTest {
    private final SumOfTwoIntegers sum = new SumOfTwoIntegers();

    @Test
    public void sampleInput1() {
        assertEquals(3, sum.getSum(1, 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(5, sum.getSum(2, 3));
    }

    @Test
    public void sampleInput3() {
        assertEquals(-4, sum.getSum(-10, 6));
    }
}
