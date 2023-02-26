package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class DivisibilityArrayOfStringTest {
    private final DivisibilityArrayOfString div = new DivisibilityArrayOfString();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new int[]{0, 1, 0, 1}, div.divisibilityArray("1010", 10));
    }
}
