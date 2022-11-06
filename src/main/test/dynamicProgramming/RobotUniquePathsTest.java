package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RobotUniquePathsTest {
    private final RobotUniquePaths paths = new RobotUniquePaths();

    @Test
    public void sampleInput1() {
        assertEquals(28, paths.uniquePaths(3, 7));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, paths.uniquePaths(3, 2));
    }

    @Test
    public void sampleInput3() {
        assertEquals(1, paths.uniquePaths(1, 1));
    }

    @Test
    public void sampleInput4() {
        assertEquals(193536720, paths.uniquePaths(23, 12));
    }
}
