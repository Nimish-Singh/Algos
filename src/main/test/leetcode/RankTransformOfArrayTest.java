package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class RankTransformOfArrayTest {
    private final RankTransformOfArray rank = new RankTransformOfArray();
    private int[] arr;

    @Test
    public void sampleInput1() {
        arr = new int[]{40, 10, 20, 30};
        assertArrayEquals(new int[]{4, 1, 2, 3}, rank.arrayRankTransform(arr));
    }

    @Test
    public void sampleInput2() {
        arr = new int[]{100, 100, 100};
        assertArrayEquals(new int[]{1, 1, 1}, rank.arrayRankTransform(arr));
    }

    @Test
    public void sampleInput3() {
        arr = new int[]{37, 12, 28, 9, 100, 56, 80, 5, 12};
        assertArrayEquals(new int[]{5, 3, 4, 2, 8, 6, 7, 1, 3}, rank.arrayRankTransform(arr));
    }
}