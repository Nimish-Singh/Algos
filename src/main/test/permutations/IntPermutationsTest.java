package permutations;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class IntPermutationsTest {
    private IntPermutations permutations = new IntPermutations();

    @Test
    public void sampleInput1() {
        List<List<Integer>> permutations = this.permutations.compute(Arrays.asList(1, 3, 5));
        assertEquals(6, permutations.size());
        assertTrue(permutations.contains(Arrays.asList(1, 3, 5)));
        assertTrue(permutations.contains(Arrays.asList(1, 5, 3)));
        assertTrue(permutations.contains(Arrays.asList(3, 1, 5)));
        assertTrue(permutations.contains(Arrays.asList(3, 5, 1)));
        assertTrue(permutations.contains(Arrays.asList(5, 1, 3)));
        assertTrue(permutations.contains(Arrays.asList(5, 3, 1)));
    }
}
