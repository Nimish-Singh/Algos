package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BullsAndCowsTest {
    private final BullsAndCows b = new BullsAndCows();

    @Test
    public void sampleInput1() {
        assertEquals("1A3B", b.getHint("1807", "7810"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("1A1B", b.getHint("1123", "0111"));
    }
}
