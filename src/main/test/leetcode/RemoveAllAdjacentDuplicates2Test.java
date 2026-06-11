package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveAllAdjacentDuplicates2Test {
    private final RemoveAllAdjacentDuplicates2 remove = new RemoveAllAdjacentDuplicates2();

    @Test
    public void sampleInput1() {
        assertEquals("abcd", remove.removeDuplicates("abcd", 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals("aa", remove.removeDuplicates("deeedbbcccbdaa", 3));
    }

    @Test
    public void sampleInput3() {
        assertEquals("ps", remove.removeDuplicates("pbbcggttciiippooaais", 2));
    }
}
