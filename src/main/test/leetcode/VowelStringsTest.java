package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class VowelStringsTest {
    private final VowelStrings vs = new VowelStrings();
    private String[] words;
    private int[][] queries;

    @Test
    public void sampleInput1() {
        words = new String[]{"aba", "bcb", "ece", "aa", "e"};
        queries = new int[][]{{0, 2},
                              {1, 4},
                              {1, 1}};
        assertArrayEquals(new int[]{2, 3, 0}, vs.vowelStrings(words, queries));
    }

    @Test
    public void sampleInput2() {
        words = new String[]{"a", "e", "i"};
        queries = new int[][]{{0, 2},
                              {0, 1},
                              {2, 2}};
        assertArrayEquals(new int[]{3, 2, 1}, vs.vowelStrings(words, queries));
    }
}
