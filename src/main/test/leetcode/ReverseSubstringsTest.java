package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ReverseSubstringsTest {
    private final ReverseSubstrings reverse = new ReverseSubstrings();

    @Test
    public void sampleInput1() {
        assertEquals("dcba", reverse.reverseParentheses("(abcd)"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("iloveu", reverse.reverseParentheses("(u(love)i)"));
    }

    @Test
    public void sampleInput3() {
        assertEquals("leetcode", reverse.reverseParentheses("(ed(et(oc))el)"));
    }
}
