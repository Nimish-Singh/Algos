package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class OnesAndZeroesTest {
    private final OnesAndZeroes oz = new OnesAndZeroes();
    private String[] strs;

    @Test
    public void sampleInput1() {
        strs = new String[]{"10", "0001", "111001", "1", "0"};
        assertEquals(4, oz.findMaxForm(strs, 5, 3));
    }

    @Test
    public void sampleInput2() {
        strs = new String[]{"10", "0", "1"};
        assertEquals(2, oz.findMaxForm(strs, 1, 1));
    }
}
