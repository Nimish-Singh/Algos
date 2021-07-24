package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MoveRobotTest {
    private MoveRobot moveRobot = new MoveRobot();
    private int[][] grid;

    @Test
    public void sampleInput1() {
        grid = new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}};
        assertEquals(2, moveRobot.uniquePathsWithObstacles(grid));
    }

    @Test
    public void sampleInput2() {
        grid = new int[][]{{0, 1}, {0, 0}};
        assertEquals(1, moveRobot.uniquePathsWithObstacles(grid));
    }
}
