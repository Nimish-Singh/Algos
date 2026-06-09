package leetcode;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class MinimumAbsoluteDifferenceTest {
    private final MinimumAbsoluteDifference min = new MinimumAbsoluteDifference();
    private int[] arr;

    @Test
    public void sampleInput1() {
        arr = new int[]{4, 2, 1, 3};
        List<List<Integer>> answer = min.minimumAbsDifference(arr);

        assertEquals(3, answer.size());
        assertArrayEquals(new int[]{1, 2}, answer.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{2, 3}, answer.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{3, 4}, answer.get(2).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput2() {
        arr = new int[]{1, 3, 6, 10, 15};
        List<List<Integer>> answer = min.minimumAbsDifference(arr);

        assertEquals(1, answer.size());
        assertArrayEquals(new int[]{1, 3}, answer.get(0).stream().mapToInt(x -> x).toArray());
    }

    @Test
    public void sampleInput3() {
        arr = new int[]{3, 8, -10, 23, 19, -4, -14, 27};
        List<List<Integer>> answer = min.minimumAbsDifference(arr);

        assertEquals(3, answer.size());
        assertArrayEquals(new int[]{-14, -10}, answer.get(0).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{19, 23}, answer.get(1).stream().mapToInt(x -> x).toArray());
        assertArrayEquals(new int[]{23, 27}, answer.get(2).stream().mapToInt(x -> x).toArray());
    }
}
