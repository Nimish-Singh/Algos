package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class NumberToAlphabetsComboTest {
    private NumberToAlphabetsCombo comboGenerator = new NumberToAlphabetsCombo();

    @Test
    public void sampleInput1() {
        List<String> combinations = comboGenerator.getCombinations(12258);
        assertEquals(5, combinations.size());
        assertTrue(combinations.contains("abbeh"));
        assertTrue(combinations.contains("aveh"));
        assertTrue(combinations.contains("abyh"));
        assertTrue(combinations.contains("lbeh"));
        assertTrue(combinations.contains("lyh"));
    }

    @Test
    public void sampleInput2() {
        List<String> combinations = comboGenerator.getCombinations(1020);
        assertEquals(1, combinations.size());
        assertTrue(combinations.contains("jt"));
    }
}
