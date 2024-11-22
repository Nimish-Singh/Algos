package backtracking;

import org.junit.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class CombinationSum3Test {
    private final CombinationSum3 combinationSum3 = new CombinationSum3();

    @Test
    public void sampleInput1() {
        List<List<Integer>> combinations = combinationSum3.combinationSum3(3, 7);

        assertEquals(1, combinations.size());
        assertArrayEquals(new int[] {1, 2, 4}, combinations.get(0).stream().mapToInt( i -> i).toArray());
    }

    @Test
    public void sampleInput2() {
        List<List<Integer>> combinations = combinationSum3.combinationSum3(3, 9);

        assertEquals(3, combinations.size());
        assertArrayEquals(new int[] {1, 2, 6}, combinations.get(0).stream().mapToInt( i -> i).toArray());
        assertArrayEquals(new int[] {1, 3, 5}, combinations.get(1).stream().mapToInt( i -> i).toArray());
        assertArrayEquals(new int[] {2, 3, 4}, combinations.get(2).stream().mapToInt( i -> i).toArray());
    }

    @Test
    public void sampleInput3() {
        List<List<Integer>> combinations = combinationSum3.combinationSum3(4, 1);

        assertTrue(combinations.isEmpty());
    }

    @Test
    public void sampleInput4() {
        List<List<Integer>> combinations = combinationSum3.combinationSum3(9, 45);

        assertEquals(1, combinations.size());
        assertArrayEquals(new int[] {1, 2, 3, 4, 5, 6, 7, 8, 9}, combinations.get(0).stream().mapToInt( i -> i).toArray());
    }
}
