package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinInsertionsToMakePalindromeTest {
    private final MinInsertionsToMakePalindrome min =  new MinInsertionsToMakePalindrome();

    @Test
    public void sampleInput1() {
        assertEquals(0, min.minInsertions("zzazz"));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, min.minInsertions("mbadm"));
    }

    @Test
    public void sampleInput3() {
        assertEquals(5, min.minInsertions("leetcode"));
    }
}
