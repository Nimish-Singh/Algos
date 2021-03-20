package permutations;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SubsetsWithDuplicateElementsTest {
    private SubsetsWithDuplicateElements subsets = new SubsetsWithDuplicateElements();

    @Test
    public void sampleInput1() {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(3);
        set.add(3);
        List<List<Integer>> subsets = this.subsets.compute(set);
        assertEquals(6, subsets.size());
        assertTrue(subsets.contains(Collections.emptyList()));
        assertTrue(subsets.contains(Collections.singletonList(1)));
        assertTrue(subsets.contains(Collections.singletonList(3)));
        assertTrue(subsets.contains(Arrays.asList(1, 3)));
        assertTrue(subsets.contains(Arrays.asList(3, 3)));
        assertTrue(subsets.contains(Arrays.asList(1, 3, 3)));
    }

    @Test
    public void sampleInput2() {
        ArrayList<Integer> set = new ArrayList<>();
        set.add(1);
        set.add(5);
        set.add(3);
        set.add(3);
        List<List<Integer>> subsets = this.subsets.compute(set);
        assertEquals(12, subsets.size());
        assertTrue(subsets.contains(Collections.emptyList()));
        assertTrue(subsets.contains(Collections.singletonList(1)));
        assertTrue(subsets.contains(Collections.singletonList(5)));
        assertTrue(subsets.contains(Collections.singletonList(3)));
        assertTrue(subsets.contains(Arrays.asList(1, 5)));
        assertTrue(subsets.contains(Arrays.asList(1, 3)));
        assertTrue(subsets.contains(Arrays.asList(3, 5)));
        assertTrue(subsets.contains(Arrays.asList(3, 3)));
        assertTrue(subsets.contains(Arrays.asList(1, 3, 5)));
        assertTrue(subsets.contains(Arrays.asList(1, 3, 3)));
        assertTrue(subsets.contains(Arrays.asList(3, 3, 5)));
        assertTrue(subsets.contains(Arrays.asList(1, 3, 3, 5)));
    }
}
