package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TribonacciNumberTest {
    private final TribonacciNumber tn = new TribonacciNumber();

    @Test
    public void sampleInput1() {
        assertEquals(4, tn.tribonacci(4));
    }

    @Test
    public void sampleInput2() {
        assertEquals(1389537, tn.tribonacci(25));
    }
}
