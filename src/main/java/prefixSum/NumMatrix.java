package prefixSum;

public class NumMatrix {
    private int[][] prefixSums;

    public NumMatrix(int[][] matrix) {
        prefixSums = new int[matrix.length][matrix[0].length];

        for (int row = 0; row < prefixSums.length; row++) {
            for (int column = 0; column < prefixSums[0].length; column++) {
                if (column == 0) {
                    prefixSums[row][column] = matrix[row][column];
                    continue;
                }

                prefixSums[row][column] = prefixSums[row][column - 1] + matrix[row][column];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        int sum = 0;
        for (int row = row1; row <= row2; row++) {
            if (col1 == 0) {
                sum += prefixSums[row][col2];
                continue;
            }

            sum += prefixSums[row][col2] - prefixSums[row][col1 - 1];
        }
        return sum;
    }
}
