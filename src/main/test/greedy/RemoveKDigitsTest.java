package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveKDigitsTest {
    private final RemoveKDigits rem = new RemoveKDigits();

    @Test
    public void sampleInput1() {
        assertEquals("1219", rem.removeKdigits("1432219", 3));
    }

    @Test
    public void sampleInput2() {
        assertEquals("200", rem.removeKdigits("10200", 1));
    }

    @Test
    public void sampleInput3() {
        assertEquals("0", rem.removeKdigits("10", 2));
    }

    @Test
    public void sampleInput4() {
        assertEquals("0", rem.removeKdigits("", 3));
    }

    @Test
    public void sampleInput5() {
        assertEquals("123", rem.removeKdigits("12345", 2));
    }
}
