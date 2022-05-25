package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ClimbingStairsTest {
    private ClimbingStairs cs = new ClimbingStairs();

    @Test
    public void sampleInput1() {
        assertEquals(2, cs.climbStairs(2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, cs.climbStairs(3));
    }
}
