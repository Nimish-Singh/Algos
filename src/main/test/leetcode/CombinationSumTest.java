package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class CombinationSumTest {
    private CombinationSum sum = new CombinationSum();
    private int[] candidates;

    @Test
    public void sampleInput1() {
        candidates = new int[]{2, 3, 6, 7};
        List<List<Integer>> combinations = sum.combinationSum(candidates, 7);

        assertEquals(2, combinations.size());
        assertTrue(combinations.contains(Arrays.asList(2, 2, 3)));
        assertTrue(combinations.contains(Collections.singletonList(7)));
    }

    @Test
    public void sampleInput2() {
        candidates = new int[]{2, 3, 5};
        List<List<Integer>> combinations = sum.combinationSum(candidates, 8);

        assertEquals(3, combinations.size());
        assertTrue(combinations.contains(Arrays.asList(2, 2, 2, 2)));
        assertTrue(combinations.contains(Arrays.asList(2, 3, 3)));
        assertTrue(combinations.contains(Arrays.asList(3, 5)));
    }

    @Test
    public void sampleInput3() {
        candidates = new int[]{2};
        List<List<Integer>> combinations = sum.combinationSum(candidates, 1);

        assertTrue(combinations.isEmpty());
    }

    @Test
    public void sampleInput4() {
        candidates = new int[]{1};
        List<List<Integer>> combinations = sum.combinationSum(candidates, 1);

        assertEquals(1, combinations.size());
        assertTrue(combinations.contains(Collections.singletonList(1)));
    }

    @Test
    public void sampleInput5() {
        candidates = new int[]{1};
        List<List<Integer>> combinations = sum.combinationSum(candidates, 2);

        assertEquals(1, combinations.size());
        assertTrue(combinations.contains(Arrays.asList(1, 1)));
    }
}
