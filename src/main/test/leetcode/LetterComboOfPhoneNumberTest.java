package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LetterComboOfPhoneNumberTest {
    private LetterComboOfPhoneNumber combinator = new LetterComboOfPhoneNumber();

    @Test
    public void sampleInput1() {
        List<String> expectedList = Arrays.asList("ad","ae","af","bd","be","bf","cd","ce","cf");
        List<String> actualList = combinator.letterCombinations("23");
        assertEquals(expectedList.size(), actualList.size());
        assertTrue(expectedList.containsAll(actualList));
    }

    @Test
    public void sampleInput2() {
        assertTrue(combinator.letterCombinations("").isEmpty());
    }

    @Test
    public void sampleInput3() {
        List<String> expectedList = Arrays.asList("a", "b", "c");
        List<String> actualList = combinator.letterCombinations("2");
        assertEquals(expectedList.size(), actualList.size());
        assertTrue(expectedList.containsAll(actualList));
    }
}
