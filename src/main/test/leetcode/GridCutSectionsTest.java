package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class GridCutSectionsTest {
    private final GridCutSections gridCutSections = new GridCutSections();
    private int[][] rectangles;

    @Test
    public void sampleInput1() {
        rectangles = new int[][]{{1, 0, 5, 2}, {0, 2, 2, 4}, {3, 2, 5, 3}, {0, 4, 4, 5}};
        assertTrue(gridCutSections.checkValidCuts(5, rectangles));
    }

    @Test
    public void sampleInput2() {
        rectangles = new int[][]{{0, 0, 1, 1}, {2, 0, 3, 4}, {0, 2, 2, 3}, {3, 0, 4, 3}};
        assertTrue(gridCutSections.checkValidCuts(4, rectangles));
    }

    @Test
    public void sampleInput3() {
        rectangles = new int[][]{{0, 2, 2, 4}, {1, 0, 3, 2}, {2, 2, 3, 4}, {3, 0, 4, 2}, {3, 2, 4, 4}};
        assertFalse(gridCutSections.checkValidCuts(4, rectangles));
    }

    @Test
    public void sampleInput4() {
        rectangles = new int[][]{{0, 0, 1, 4}, {1, 0, 2, 4}, {2, 0, 3, 4}, {3, 0, 4, 4}};
        assertTrue(gridCutSections.checkValidCuts(4, rectangles));
    }

    @Test
    public void sampleInput5() {
        rectangles = new int[][]{{0, 0, 1, 4}, {1, 0, 2, 3}, {2, 0, 3, 3}, {3, 0, 4, 3}, {1, 3, 4, 4}};
        assertFalse(gridCutSections.checkValidCuts(4, rectangles));
    }
}
