package blind75.matrix;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// https://leetcode.com/problems/spiral-matrix/
public class SpiralMatrix {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix == null || matrix.length == 0)
            return Collections.emptyList();

        int leftLimit = 0, rightLimit = matrix[0].length - 1, upLimit = 0, downLimit = matrix.length - 1;
        int visitedCount = 0, expectedVisitedCount = matrix.length * matrix[0].length;

        List<Integer> spiral = new ArrayList<>();
        while (visitedCount != expectedVisitedCount) {
            for (int index = leftLimit; index <= rightLimit && visitedCount != expectedVisitedCount; index++) {
                spiral.add(matrix[upLimit][index]);
                visitedCount++;
            }
            upLimit++;

            for (int index = upLimit; index <= downLimit && visitedCount != expectedVisitedCount; index++) {
                spiral.add(matrix[index][rightLimit]);
                visitedCount++;
            }
            rightLimit--;

            for (int index = rightLimit; index >= leftLimit && visitedCount != expectedVisitedCount; index--) {
                spiral.add(matrix[downLimit][index]);
                visitedCount++;
            }
            downLimit--;

            for (int index = downLimit; index >= upLimit && visitedCount != expectedVisitedCount; index--) {
                spiral.add(matrix[index][leftLimit]);
                visitedCount++;
            }
            leftLimit++;
        }
        return spiral;
    }
}
