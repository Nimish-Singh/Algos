package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class SpecialStringTest {
    private final SpecialString specialString = new SpecialString();

    @Test
    public void sampleInput1() {
        assertTrue(specialString.isSpecial("abcad"));
    }

    @Test
    public void sampleInput2() {
        assertFalse(specialString.isSpecial("d"));
    }
}
