package blind75.stack;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidParenthesesTest {
    private final ValidParentheses valid = new ValidParentheses();

    @Test
    public void sampleInput1() {
        assertTrue(valid.isValid("()"));
    }

    @Test
    public void sampleInput2() {
        assertTrue(valid.isValid("()[]{}"));
    }

    @Test
    public void sampleInput3() {
        assertFalse(valid.isValid("(]"));
    }
}
