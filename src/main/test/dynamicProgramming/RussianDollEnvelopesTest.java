package dynamicProgramming;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RussianDollEnvelopesTest {
    private final RussianDollEnvelopes rd = new RussianDollEnvelopes();
    private int[][] envelopes;

    @Test
    public void sampleInput1() {
        envelopes = new int[][]{{5, 4},
                                {6, 4},
                                {6, 7},
                                {2, 3}};
        assertEquals(3, rd.maxEnvelopes(envelopes));
    }

    @Test
    public void sampleInput2() {
        envelopes = new int[][]{{1, 1},
                                {1, 1},
                                {1, 1}};
        assertEquals(1, rd.maxEnvelopes(envelopes));
    }
}
