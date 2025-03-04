package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AllOneTest {
    private AllOne allOne;

    @Test
    public void sampleInput1() {
        allOne = new AllOne();

        allOne.inc("hello");
        allOne.inc("hello");
        assertEquals("hello", allOne.getMaxKey());
        assertEquals("hello", allOne.getMinKey());

        allOne.inc("leet");
        assertEquals("hello", allOne.getMaxKey());
        assertEquals("leet", allOne.getMinKey());
    }

    @Test
    public void sampleInput2() {
        allOne = new AllOne();

        allOne.inc("a");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.inc("b");
        allOne.dec("b");
        allOne.dec("b");
        assertEquals("b", allOne.getMaxKey());
        assertEquals("a", allOne.getMinKey());
    }
}
