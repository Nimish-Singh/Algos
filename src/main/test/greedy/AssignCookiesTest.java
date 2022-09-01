package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AssignCookiesTest {
    private final AssignCookies assign = new AssignCookies();
    private int[] greed;
    private int[] sizes;

    @Test
    public void sampleInput1() {
        assertEquals(1, assign.findContentChildren(new int[]{1, 2, 3}, new int[]{1, 1}));
    }

    @Test
    public void sampleInput2() {
        assertEquals(2, assign.findContentChildren(new int[]{1, 2}, new int[]{1, 2, 3}));
    }

    @Test
    public void sampleInput3() {
        assertEquals(2, assign.findContentChildren(new int[]{10, 9, 8, 7}, new int[]{5, 6, 7, 8}));
    }
}
