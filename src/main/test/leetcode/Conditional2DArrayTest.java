package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class Conditional2DArrayTest {
    private final Conditional2DArray c = new Conditional2DArray();
    private int[] nums;

    @Test
    public void sampleInput1() {
        nums = new int[]{1, 3, 4, 1, 2, 3, 1};
        List<List<Integer>> matrix = c.findMatrix(nums);
        assertEquals(3, matrix.size());
        assertArrayEquals(new int[]{1, 3, 4, 2}, matrix.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{1, 3}, matrix.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{1}, matrix.get(2).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        nums = new int[]{1, 2, 3, 4};
        List<List<Integer>> matrix = c.findMatrix(nums);
        assertEquals(1, matrix.size());
        assertArrayEquals(new int[]{1, 2, 3, 4}, matrix.get(0).stream().mapToInt(x -> x).toArray());
    }
}
