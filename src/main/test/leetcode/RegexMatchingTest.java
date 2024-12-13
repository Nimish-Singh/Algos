package leetcode;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegexMatchingTest {
    private final RegexMatching regexMatching = new RegexMatching();

    @Test
    public void sampleInput1() {
        assertFalse(regexMatching.isMatch("aa", "a"));
    }

    @Test
    public void sampleInput2() {
        assertTrue(regexMatching.isMatch("aa", "a*"));
    }

    @Test
    public void sampleInput3() {
        assertTrue(regexMatching.isMatch("ab", ".*"));
    }

    @Test
    public void sampleInput4() {
        assertTrue(regexMatching.isMatch("", ""));
    }

    @Test
    public void sampleInput5() {
        assertFalse(regexMatching.isMatch("ab", ""));
    }
}
