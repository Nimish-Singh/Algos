package priorityQueue;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class KPairsWithSmallestSumsTest {
    private final KPairsWithSmallestSums kPairs = new KPairsWithSmallestSums();
    private int[] nums1;
    private int[] nums2;

    @Test
    public void sampleInput1() {
        nums1 = new int[]{1, 7, 11};
        nums2 = new int[]{2, 4, 6};
        List<List<Integer>> returnedList = kPairs.kSmallestPairs(nums1, nums2, 3);
        assertEquals(3, returnedList.size());
        assertTrue(returnedList.contains(List.of(1, 2)));
        assertTrue(returnedList.contains(List.of(1, 4)));
        assertTrue(returnedList.contains(List.of(1, 6)));
    }

    @Test
    public void sampleInput2() {
        nums1 = new int[]{1, 1, 2};
        nums2 = new int[]{1, 2, 3};
        List<List<Integer>> returnedList = kPairs.kSmallestPairs(nums1, nums2, 2);
        assertEquals(2, returnedList.size());
        assertTrue(returnedList.contains(List.of(1, 1)));
        assertTrue(returnedList.contains(List.of(1, 1)));

    }
}
