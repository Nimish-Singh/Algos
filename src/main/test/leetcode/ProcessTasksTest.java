package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ProcessTasksTest {
    private final ProcessTasks pt = new ProcessTasks();
    private int[] servers;
    private int[] tasks;

    @Test
    public void sampleInput1() {
        servers = new int[]{3, 3, 2};
        tasks = new int[]{1, 2, 3, 2, 1, 2};
        int[] answer = pt.assignTasks(servers, tasks);

        assertArrayEquals(new int[]{2, 2, 0, 2, 1, 2}, answer);
    }

    @Test
    public void sampleInput2() {
        servers = new int[]{5, 1, 4, 3, 2};
        tasks = new int[]{2, 1, 2, 4, 5, 2, 1};
        int[] answer = pt.assignTasks(servers, tasks);

        assertArrayEquals(new int[]{1, 4, 1, 4, 1, 3, 2}, answer);
    }

    @Test
    public void sampleInput3() {
        servers = new int[]{10, 63, 95, 16, 85, 57, 83, 95, 6, 29, 71};
        tasks = new int[]{70, 31, 83, 15, 32, 67, 98, 65, 56, 48, 38, 90, 5};
        int[] answer = pt.assignTasks(servers, tasks);

        assertArrayEquals(new int[]{8, 0, 3, 9, 5, 1, 10, 6, 4, 2, 7, 9, 0}, answer);
    }
}
