package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class UniquePathsTest {
    private final UniquePaths up = new UniquePaths();

    @Test
    public void sampleInput1() {
        assertEquals(28, up.uniquePaths(3, 7));
    }

    @Test
    public void sampleInput2() {
        assertEquals(3, up.uniquePaths(3, 2));
    }

    @Test
    public void sampleInput3() {
        assertEquals(86493225, up.uniquePaths(19, 13));
    }
}
