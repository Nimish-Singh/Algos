package permutations;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class ValidParenthesisCombosTest {
    private ValidParenthesisCombos combos = new ValidParenthesisCombos();

    @Test
    public void sampleInput1() {
        List<String> parentheses = combos.generate(2);
        assertEquals(2, parentheses.size());
        assertTrue(parentheses.contains("(())"));
        assertTrue(parentheses.contains("()()"));
    }

    @Test
    public void sampleInput2() {
        List<String> parentheses = combos.generate(3);
        assertEquals(5, parentheses.size());
        assertTrue(parentheses.contains("((()))"));
        assertTrue(parentheses.contains("(()())"));
        assertTrue(parentheses.contains("(())()"));
        assertTrue(parentheses.contains("()(())"));
        assertTrue(parentheses.contains("()()()"));
    }
}
