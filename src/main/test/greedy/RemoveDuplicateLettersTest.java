package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveDuplicateLettersTest {
    private final RemoveDuplicateLetters remove = new RemoveDuplicateLetters();

    @Test
    public void sampleInput1() {
        assertEquals("abc", remove.removeDuplicateLetters("bcabc"));
    }

    @Test
    public void sampleInput2() {
        assertEquals("acdb", remove.removeDuplicateLetters("cbacdcbc"));
    }
}
