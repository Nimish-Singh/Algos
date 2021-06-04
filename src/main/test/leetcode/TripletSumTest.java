package leetcode;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class TripletSumTest {
    private TripletSum sum = new TripletSum();

    @Test
    public void sampleInput1() {
        List<List<Integer>> list = sum.threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        assertEquals(2, list.size());
        assertTrue(list.contains(Arrays.asList(-1, -1, 2)));
        assertTrue(list.contains(Arrays.asList(-1, 0, 1)));
    }
}
