package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RemoveAdjacentDuplicatesTest {
    private final RemoveAdjacentDuplicates rm = new RemoveAdjacentDuplicates();

    @Test
    public void sampleInput1() {
        assertEquals("abcd", rm.removeDuplicates("abcd", 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals("aa", rm.removeDuplicates("deeedbbcccbdaa", 3));
    }

    @Test
    public void sampleInput3() {
        assertEquals("ps", rm.removeDuplicates("pbbcggttciiippooaais", 2));
    }

    @Test
    public void sampleInput4() {
        assertEquals("", rm.removeDuplicates("", 2));
    }

    @Test
    public void sampleInput5() {
        assertEquals("qwwwe", rm.removeDuplicates("qwwwe", 0));
    }
}
