package prefixSum;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class CanMakePalindromeTest {
    private CanMakePalindrome pal = new CanMakePalindrome();
    private boolean[] expectedOutput;
    private String input;
    private int[][] queries;

    @Test
    public void sampleInput1() {
        expectedOutput = new boolean[]{true, false, false, true, true};
        input = "abcda";
        queries = new int[][]{{3, 3, 0},
                              {1, 2, 0},
                              {0, 3, 1},
                              {0, 3, 2},
                              {0, 4, 1}};
        List<Boolean> actualOutput = pal.canMakePaliQueries(input, queries);

        assertValues(actualOutput);
    }

    @Test
    public void sampleInput2() {
        expectedOutput = new boolean[]{false, true};
        input = "lyb";
        queries = new int[][]{{0, 1, 0},
                              {2, 2, 1}};
        List<Boolean> actualOutput = pal.canMakePaliQueries(input, queries);

        assertValues(actualOutput);
    }

    private void assertValues(List<Boolean> actualOutput) {
        for (int index = 0; index < expectedOutput.length; index++) {
            assertEquals(expectedOutput[index], actualOutput.get(index));
        }
    }
}
