package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class NumArrayPermutationsTest {
    private NumArrayPermutations numArrayPermutations = new NumArrayPermutations();

    @Test
    public void sampleInput1() {
        List<List<Integer>> actualList = numArrayPermutations.permute(new int[]{1});
        assertEquals(actualList.size(), 1);
        assertEquals(actualList.get(0), Collections.singletonList(1));
    }

    @Test
    public void sampleInput2() {
        List<List<Integer>> actualList = numArrayPermutations.permute(new int[]{0, 1});
        assertEquals(actualList.size(), 2);
        assertTrue(actualList.contains(Arrays.asList(0, 1)));
        assertTrue(actualList.contains(Arrays.asList(1, 0)));
    }

    @Test
    public void sampleInput3() {
        List<List<Integer>> actualList = numArrayPermutations.permute(new int[]{1, 2, 3});
        assertEquals(actualList.size(), 6);
        assertTrue(actualList.contains(Arrays.asList(1, 2, 3)));
        assertTrue(actualList.contains(Arrays.asList(1, 3, 2)));
        assertTrue(actualList.contains(Arrays.asList(2, 1, 3)));
        assertTrue(actualList.contains(Arrays.asList(2, 3, 1)));
        assertTrue(actualList.contains(Arrays.asList(3, 1, 2)));
        assertTrue(actualList.contains(Arrays.asList(3, 2, 1)));
    }
}
