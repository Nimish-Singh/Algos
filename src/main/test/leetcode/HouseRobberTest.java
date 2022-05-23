package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class HouseRobberTest {
    private HouseRobber hr = new HouseRobber();

    @Test
    public void sampleInput1() {
        assertEquals(4, hr.rob(new int[]{1, 2, 3, 1}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(12, hr.rob(new int[]{2, 7, 9, 3, 1}));
    }

    @Test
    public void sampleInput3() {
        assertEquals(4, hr.rob(new int[]{2, 1, 1, 2}));
    }

    @Test
    public void sampleInput4() {
        assertEquals(0, hr.rob(new int[]{}));
    }

    @Test
    public void sampleInput5() {
        assertEquals(1, hr.rob(new int[]{1}));
    }

    @Test
    public void sampleInput6() {
        assertEquals(103, hr.rob(new int[]{1, 3, 1, 3, 100}));
    }
}
