package differenceArray;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class CorporateFlightBookingsTest {
    private final CorporateFlightBookings cfb = new CorporateFlightBookings();
    private int[][] bookings;

    @Test
    public void sampleInput1() {
        bookings = new int[][]{{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        assertArrayEquals(new int[]{10, 55, 45, 25, 25}, cfb.corpFlightBookings(bookings, 5));
    }

    @Test
    public void sampleInput2() {
        bookings = new int[][]{{1, 2, 10}, {2, 2, 15}};
        assertArrayEquals(new int[]{10, 25}, cfb.corpFlightBookings(bookings, 2));
    }
}
