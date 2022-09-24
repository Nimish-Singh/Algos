package blind75.twoPointer;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidPalindromeTest {
    private final ValidPalindrome valid = new ValidPalindrome();

    @Test
    public void sampleInput1() {
        assertTrue(valid.isPalindrome("A man, a plan, a canal: Panama"));
    }

    @Test
    public void sampleInput2() {
        assertTrue(valid.isPalindrome(""));
    }

    @Test
    public void sampleInput3() {
        assertFalse(valid.isPalindrome("race a car"));
    }
}
