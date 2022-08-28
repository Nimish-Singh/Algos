package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinTicketsCostTest {
    private final MinTicketsCost min = new MinTicketsCost();
    private int[] days;
    private int[] costs;

    @Test
    public void sampleInput1() {
        days = new int[]{1, 4, 6, 7, 8, 20};
        costs = new int[]{2, 7, 15};
        assertEquals(11, min.mincostTickets(days, costs));
    }

    @Test
    public void sampleInput2() {
        days = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 30, 31};
        costs = new int[]{2, 7, 15};
        assertEquals(17, min.mincostTickets(days, costs));
    }

    @Test
    public void sampleInput3() {
        days = new int[]{1, 4, 6, 7, 8, 20};
        costs = new int[]{7, 2, 15};
        assertEquals(6, min.mincostTickets(days, costs));
    }

    @Test
    public void sampleInput4() {
        days = new int[]{3, 5, 6, 8, 11, 13, 15, 16, 17, 18, 19, 20, 24, 27, 30, 31, 33, 36, 37, 40, 45, 48, 51, 54, 56, 57, 61, 62, 64, 66, 67, 71, 73, 74, 77, 78, 80, 81, 83, 84, 86, 87, 90, 91, 94, 96, 97};
        costs = new int[]{3, 16, 66};
        assertEquals(139, min.mincostTickets(days, costs));
    }
}
