package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CinemaSeatAllocationTest {
    private final CinemaSeatAllocation cinema = new CinemaSeatAllocation();
    private int[][] reservedSeats;

    @Test
    public void sampleInput1() {
        reservedSeats = new int[][]{{1, 2},
                                    {1, 3},
                                    {1, 8},
                                    {2, 6},
                                    {3, 1},
                                    {3, 1}};
        assertEquals(4, cinema.maxNumberOfFamilies(3, reservedSeats));
    }

    @Test
    public void sampleInput2() {
        reservedSeats = new int[][]{{2, 1},
                                    {1, 8},
                                    {2, 6}};
        assertEquals(2, cinema.maxNumberOfFamilies(2, reservedSeats));
    }

    @Test
    public void sampleInput3() {
        reservedSeats = new int[][]{{4, 3},
                                    {1, 4},
                                    {4, 6},
                                    {1, 7}};
        assertEquals(4, cinema.maxNumberOfFamilies(4, reservedSeats));
    }
}
