package twoPointer;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TripletSumCloseToTargetTest {
    private TripletSumCloseToTarget triplet = new TripletSumCloseToTarget();

    @Test
    public void sampleInput1() {
        assertEquals(1, triplet.searchTriplet(new int[] {-2, 0, 1, 2}, 2));
    }

    @Test
    public void sampleInput2() {
        assertEquals(0, triplet.searchTriplet(new int[] {-3, -1, 1, 2}, 1));
    }

    @Test
    public void sampleInput3() {
        assertEquals(3, triplet.searchTriplet(new int[] {1, 0, 1, 1}, 100));
    }
}
