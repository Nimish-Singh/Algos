package blind75.matrix;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/set-matrix-zeroes/
public class SetMatrixZeroes {
    public void setZeroes(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return;

        Set<Integer> rowsToMakeZero = new HashSet<>();
        Set<Integer> columnsToMakeZero = new HashSet<>();
        int totalRows = matrix.length;
        int totalColumns = matrix[0].length;
        for (int row = 0; row < totalRows; row++) {
            for (int column = 0; column < totalColumns; column++) {
                if (matrix[row][column] == 0) {
                    rowsToMakeZero.add(row);
                    columnsToMakeZero.add(column);
                }
            }
        }

        for (int row : rowsToMakeZero) {
            for (int column = 0; column < totalColumns; column++)
                matrix[row][column] = 0;
        }

        for (int column : columnsToMakeZero) {
            for (int row = 0; row < totalRows; row++)
                matrix[row][column] = 0;
        }
    }

    // T=O(mn). S=O(m+n)
    /*
    for same T but S=O(1), use matrix[0][column] and matrix[row][0] as the respective sets, ie.,
    if a cell is 0, then mark the first row and column cell for that as 0. In the second iteration,
    turn all such rows and columns to 0. Use an initial boolean variable for matrix[0][0] to either
    use as row marker or column marker
     */
}
