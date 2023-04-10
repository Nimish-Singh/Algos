package leetcode;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrimeInDiagonalTest {
    private final PrimeInDiagonal pd = new PrimeInDiagonal();
    private int[][] nums;

    @Test
    public void sampleInput1() {
        nums = new int[][]{{1, 2, 3},
                           {5, 6, 7},
                           {9, 10, 11}};
        assertEquals(11, pd.diagonalPrime(nums));
    }

    @Test
    public void sampleInput2() {
        nums = new int[][]{{1, 2, 3},
                           {5, 17, 7},
                           {9, 11, 10}};
        assertEquals(17, pd.diagonalPrime(nums));
    }

    @Test
    public void sampleInput3() {
        nums = new int[][]{{4, 2, 33},
                           {5, 1, 7},
                           {9, 11, 10}};
        assertEquals(0, pd.diagonalPrime(nums));
    }

    @Test
    public void sampleInput4() {
        nums = new int[][]{{1, 1, 1},
                           {1, 1, 1},
                           {1, 1, 1}};
        assertEquals(0, pd.diagonalPrime(nums));
    }
}
