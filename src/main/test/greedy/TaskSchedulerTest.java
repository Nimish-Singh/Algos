package greedy;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskSchedulerTest {
    private final TaskScheduler scheduler = new TaskScheduler();
    private char[] tasks;

    @Test
    public void sampleInput1() {
        tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        assertEquals(8, scheduler.leastInterval(tasks, 2));
    }

    @Test
    public void sampleInput2() {
        tasks = new char[]{'A', 'A', 'A', 'B', 'B', 'B'};
        assertEquals(6, scheduler.leastInterval(tasks, 0));
    }

    @Test
    public void sampleInput3() {
        tasks = new char[]{'A', 'A', 'A', 'A', 'A', 'A', 'B', 'C', 'D', 'E', 'F', 'G'};
        assertEquals(16, scheduler.leastInterval(tasks, 2));
    }
}
