package dynamicProgramming;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class RodCuttingProblemTest {
    private RodCuttingProblem rodCuttingProblem = new RodCuttingProblem();

    @Test
    public void shouldGiveMaximumProfitValue() {
        assertEquals(13, rodCuttingProblem.maximumProfitBottomUp(5));
    }

    @Test
    public void shouldReturnSeriesOfCuts() {
        assertEquals(Arrays.asList(1, 6), rodCuttingProblem.cutSizesUsingBottomUpApproach(7));
    }
}
