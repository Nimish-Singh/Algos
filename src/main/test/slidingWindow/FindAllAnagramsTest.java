package slidingWindow;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class FindAllAnagramsTest {
    private final FindAllAnagrams anagramIndexFinder = new FindAllAnagrams();

    @Test
    public void sampleInput1() {
        assertArrayEquals(new int[]{0, 6},
                anagramIndexFinder.findAnagrams("cbaebabacd", "abc").stream().mapToInt(x -> (int) x).toArray());
    }

    @Test
    public void sampleInput2() {
        assertArrayEquals(new int[]{0, 1, 2},
                anagramIndexFinder.findAnagrams("abab", "ab").stream().mapToInt(x -> (int) x).toArray());
    }

    @Test
    public void sampleInput3() {
        assertArrayEquals(new int[]{1},
                anagramIndexFinder.findAnagrams("baa", "aa").stream().mapToInt(x -> (int) x).toArray());
    }
}
