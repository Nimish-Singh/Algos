package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WaysToBuildGoodStringsTest {
    private final WaysToBuildGoodStrings ways = new WaysToBuildGoodStrings();

    @Test
    public void sampleInput1() {
        assertEquals(8, ways.countGoodStrings(3, 3, 1, 1));
    }

    @Test
    public void sampleInput2() {
        assertEquals(5, ways.countGoodStrings(2, 3, 1, 2));
    }
}
