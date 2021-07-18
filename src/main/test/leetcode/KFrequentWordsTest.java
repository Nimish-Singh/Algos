package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class KFrequentWordsTest {
    private KFrequentWords words = new KFrequentWords();

    @Test
    public void sampleInput1() {
        String[] input = new String[]{"i", "love", "leetcode", "i", "love", "coding"};
        String[] expectedOutput = new String[]{"i", "love"};
        assertArrayEquals(expectedOutput, words.topKFrequent(input, 2).toArray());
    }

    @Test
    public void sampleInput2() {
        String[] input = new String[]{"the", "day", "is", "sunny", "the", "the", "the", "sunny", "is", "is"};
        String[] expectedOutput = new String[]{"the", "is", "sunny", "day"};
        assertArrayEquals(expectedOutput, words.topKFrequent(input, 4).toArray());
    }
}
