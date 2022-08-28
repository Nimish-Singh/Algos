package greedy;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class QueueReconstructionTest {
    private final QueueReconstruction q = new QueueReconstruction();
    private int[][] people;
    private int[][] expectedAnswer;

    @Test
    public void sampleInput1() {
        people = new int[][]{{7, 0},
                             {4, 4},
                             {7, 1},
                             {5, 0},
                             {6, 1},
                             {5, 2}};
        expectedAnswer = new int[][]{{5, 0},
                                     {7, 0},
                                     {5, 2},
                                     {6, 1},
                                     {4, 4},
                                     {7, 1}};
        assertArrayEquals(expectedAnswer, q.reconstructQueue(people));
    }

    @Test
    public void sampleInput2() {
        people = new int[][]{{6, 0},
                             {5, 0},
                             {4, 0},
                             {3, 2},
                             {2, 2},
                             {1, 4}};
        expectedAnswer = new int[][]{{4, 0},
                                     {5, 0},
                                     {2, 2},
                                     {3, 2},
                                     {1, 4},
                                     {6, 0}};
        assertArrayEquals(expectedAnswer, q.reconstructQueue(people));
    }
}
