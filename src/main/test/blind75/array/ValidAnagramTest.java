package blind75.array;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ValidAnagramTest {
    private final ValidAnagram valid = new ValidAnagram();

    @Test
    public void sampleInput1() {
        assertTrue(valid.isAnagram("anagram", "nagaram"));
    }

    @Test
    public void sampleInput2() {
        assertFalse(valid.isAnagram("rat", "carø"));
    }
}
