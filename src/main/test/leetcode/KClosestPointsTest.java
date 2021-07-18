package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class KClosestPointsTest {
    private KClosestPoints points = new KClosestPoints();

    @Test
    public void sampleInput1() {
        int[][] input = new int[][]{{1, 3}, {-2, 2}};
        int[][] output = points.kClosest(input, 1);
        assertEquals(1, output.length);
        assertArrayEquals(new int[]{-2, 2}, output[0]);
    }

    @Test
    public void sampleInput2() {
        int[][] input = new int[][]{{3, 3}, {5, -1}, {-2, 4}};
        int[][] output = points.kClosest(input, 2);
        assertEquals(2, output.length);
        assertEquals(output[0][0], 3);
        assertEquals(output[0][1], 3);
        assertEquals(output[1][0], -2);
        assertEquals(output[1][1], 4);
    }
}
