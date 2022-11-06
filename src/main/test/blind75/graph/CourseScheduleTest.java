package blind75.graph;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class CourseScheduleTest {
    private final CourseSchedule cs = new CourseSchedule();
    int[][] prerequisites;

    @Test
    public void sampleInput1() {
        prerequisites = new int[][]{{1, 0}};
        assertTrue(cs.canFinish(2, prerequisites));
    }

    @Test
    public void sampleInput2() {
        prerequisites = new int[][]{{1, 0},
                                    {0, 1}};
        assertFalse(cs.canFinish(2, prerequisites));
    }
}
