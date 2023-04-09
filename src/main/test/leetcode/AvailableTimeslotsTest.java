package leetcode;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class AvailableTimeslotsTest {
    private AvailableTimeslots ats = new AvailableTimeslots();
    private List<List<Integer>> person1Slots;
    private List<List<Integer>> person2Slots;

    @Test
    public void whenBothHaveSomeOccupiedSlots() {
        person1Slots = Arrays.asList(Arrays.asList(2, 3),
            Arrays.asList(10, 12),
            Arrays.asList(14, 18),
            Arrays.asList(4, 7));

        person2Slots = Arrays.asList(Arrays.asList(2, 3),
            Arrays.asList(8, 9),
            Arrays.asList(3, 5),
            Arrays.asList(12, 17));

        List<List<Integer>> availableSlots = ats.findAvailableSlots(person1Slots, person2Slots);

        int[][] expectedAvailableSlots = new int[][]{
            {0, 2},
            {7, 8},
            {9, 10},
            {18, 24}
        };

        assertEquals(4, availableSlots.size());

        assertEquals(expectedAvailableSlots[0][0], availableSlots.get(0).get(0).intValue());
        assertEquals(expectedAvailableSlots[0][1], availableSlots.get(0).get(1).intValue());

        assertEquals(expectedAvailableSlots[1][0], availableSlots.get(1).get(0).intValue());
        assertEquals(expectedAvailableSlots[1][1], availableSlots.get(1).get(1).intValue());

        assertEquals(expectedAvailableSlots[2][0], availableSlots.get(2).get(0).intValue());
        assertEquals(expectedAvailableSlots[2][1], availableSlots.get(2).get(1).intValue());

        assertEquals(expectedAvailableSlots[3][0], availableSlots.get(3).get(0).intValue());
        assertEquals(expectedAvailableSlots[3][1], availableSlots.get(3).get(1).intValue());
    }

    @Test
    public void whenOnePersonHasNoOccupiedSlots() {
        person1Slots = new ArrayList<>();

        person2Slots = Arrays.asList(Arrays.asList(2, 3),
            Arrays.asList(8, 9),
            Arrays.asList(3, 5),
            Arrays.asList(12, 17));

        List<List<Integer>> availableSlots = ats.findAvailableSlots(person1Slots, person2Slots);

        int[][] expectedAvailableSlots = new int[][]{
            {0, 2},
            {5, 8},
            {9, 12},
            {17, 24}
        };

        assertEquals(4, availableSlots.size());

        assertEquals(expectedAvailableSlots[0][0], availableSlots.get(0).get(0).intValue());
        assertEquals(expectedAvailableSlots[0][1], availableSlots.get(0).get(1).intValue());

        assertEquals(expectedAvailableSlots[1][0], availableSlots.get(1).get(0).intValue());
        assertEquals(expectedAvailableSlots[1][1], availableSlots.get(1).get(1).intValue());

        assertEquals(expectedAvailableSlots[2][0], availableSlots.get(2).get(0).intValue());
        assertEquals(expectedAvailableSlots[2][1], availableSlots.get(2).get(1).intValue());

        assertEquals(expectedAvailableSlots[3][0], availableSlots.get(3).get(0).intValue());
        assertEquals(expectedAvailableSlots[3][1], availableSlots.get(3).get(1).intValue());
    }

    @Test
    public void whenBothPersonsHaveNoOccupiedSlots() {
        person1Slots = new ArrayList<>();
        person2Slots = new ArrayList<>();

        List<List<Integer>> availableSlots = ats.findAvailableSlots(person1Slots, person2Slots);

        int[][] expectedAvailableSlots = new int[][]{{0, 24}};

        assertEquals(1, availableSlots.size());

        assertEquals(expectedAvailableSlots[0][0], availableSlots.get(0).get(0).intValue());
        assertEquals(expectedAvailableSlots[0][1], availableSlots.get(0).get(1).intValue());
    }

    @Test
    public void whenBothPersonsHaveFullyOccupiedSlots() {
        person1Slots = Arrays.asList(Arrays.asList(0, 24));
        person2Slots = Arrays.asList(Arrays.asList(0, 24));

        List<List<Integer>> availableSlots = ats.findAvailableSlots(person1Slots, person2Slots);

        assertTrue(availableSlots.isEmpty());
    }

    @Test
    public void whenBothPersonsHaveDistinctButFullyOccupiedSlots() {
        person1Slots = Arrays.asList(Arrays.asList(0, 2),
            Arrays.asList(6, 15),
            Arrays.asList(19, 24));
        person2Slots = Arrays.asList(Arrays.asList(0, 7),
            Arrays.asList(15, 22));

        List<List<Integer>> availableSlots = ats.findAvailableSlots(person1Slots, person2Slots);

        assertTrue(availableSlots.isEmpty());
    }
}
