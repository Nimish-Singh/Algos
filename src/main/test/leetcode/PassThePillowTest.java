package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassThePillowTest {
    private final PassThePillow pp = new PassThePillow();

    @Test
    public void sampleInput1() {
        assertEquals(2, pp.passThePillow(4, 5));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, pp.passThePillow(3, 2));
    }
}
