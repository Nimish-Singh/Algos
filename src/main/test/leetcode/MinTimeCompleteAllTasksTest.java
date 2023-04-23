package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MinTimeCompleteAllTasksTest {
    private final MinTimeCompleteAllTasks min = new MinTimeCompleteAllTasks();
    private int[][] tasks;

    @Test
    public void sampleInput1() {
        tasks = new int[][]{{2, 3, 1},
                            {4, 5, 1},
                            {1, 5, 2}};
        assertEquals(2, min.findMinimumTime(tasks));
    }

    @Test
    public void sampleInput2() {
        tasks = new int[][]{{1, 3, 2},
                            {2, 5, 3},
                            {5, 6, 2}};
        assertEquals(4, min.findMinimumTime(tasks));
    }
}