package prefixSum;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RandomPickWithWeightTest {
    private RandomPickWithWeight randomPick;

    @Test
    public void sampleInput1() {
        randomPick = new RandomPickWithWeight(new int[]{1});
        assertEquals(0, randomPick.pickIndex());
    }
}
