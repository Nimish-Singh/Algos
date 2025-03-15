package leetcode;

import binarySearch.MaxCandies;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MaxCandiesTest {
    private final MaxCandies maxCandies = new MaxCandies();
    private int[] candies;

    @Test
    public void sampleInput1() {
        candies = new int[]{5, 8, 6};
        assertEquals(5, maxCandies.maximumCandies(candies, 3));
    }

    @Test
    public void sampleInput2() {
        candies = new int[]{2, 5};
        assertEquals(0, maxCandies.maximumCandies(candies, 11));
    }
}
