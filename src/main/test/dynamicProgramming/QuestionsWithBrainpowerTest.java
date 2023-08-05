package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuestionsWithBrainpowerTest {
    private QuestionsWithBrainpower q = new QuestionsWithBrainpower();
    private int[][] questions;

    @Test
    public void sampleInput1() {
        questions = new int[][]{{3, 2},
                                {4, 3},
                                {4, 4},
                                {2, 5}};
        assertEquals(5, q.mostPoints(questions));
    }

    @Test
    public void sampleInput2() {
        questions = new int[][]{{1, 1},
                                {2, 2},
                                {3, 3},
                                {4, 4},
                                {5, 5}};
        assertEquals(7, q.mostPoints(questions));
    }
}
