package blind75.bitManipulation;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseBitsTest {
    private final ReverseBits rev = new ReverseBits();

    @Test
    public void sampleInput1() {
        assertEquals(964176192, rev.reverseBits(43261596));
    }

    @Test
    public void sampleInput2() {
        assertEquals(-1073741825, rev.reverseBits(-3));
    }
}
