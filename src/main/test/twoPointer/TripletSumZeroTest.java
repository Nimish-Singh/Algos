package twoPointer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TripletSumZeroTest {
    private TripletSumZero tripletSumZero = new TripletSumZero();

    @Test
    public void sampleInput1() {
        List<List<Integer>> actualList = tripletSumZero.searchTriplets(new int[]{-3, 0, 1, 2, -1, 1, -2});
        assertEquals(4, actualList.size());
        assertTrue(actualList.contains(Arrays.asList(-3, 1, 2)));
        assertTrue(actualList.contains(Arrays.asList(-2, 0, 2)));
        assertTrue(actualList.contains(Arrays.asList(-2, 1, 1)));
        assertTrue(actualList.contains(Arrays.asList(-1, 0, 1)));
    }

    @Test
    public void sampleInput2() {
        List<List<Integer>> actualList = tripletSumZero.searchTriplets(new int[]{-5, 2, -1, -2, 3});
        assertEquals(2, actualList.size());
        assertTrue(actualList.contains(Arrays.asList(-5, 2, 3)));
        assertTrue(actualList.contains(Arrays.asList(-2, -1, 3)));
    }
}
