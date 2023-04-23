package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class VowelStringsInRangeTest {
    private final VowelStringsInRange vowelStrings = new VowelStringsInRange();
    private String[] words;

    @Test
    public void sampleInput1() {
        words = new String[]{"are", "amy", "u"};
        assertEquals(2, vowelStrings.vowelStrings(words, 0, 2));
    }

    @Test
    public void sampleInput2() {
        words = new String[]{"hey", "aeo", "mu", "ooo", "artro"};
        assertEquals(3, vowelStrings.vowelStrings(words, 1, 4));
    }
}
