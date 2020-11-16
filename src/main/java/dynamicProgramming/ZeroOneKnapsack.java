package dynamicProgramming;

import java.util.Arrays;

public class ZeroOneKnapsack {
    int maxValue(int[] values, int[] weights, int capacity) {
        if (values.length != weights.length) {
            return 0;
        }
//        return maxValueRecursive(values, weights, 0, capacity, 0);
        int[][] maxValueSoFar = new int[values.length + 1][capacity + 1];
        for (int[] array : maxValueSoFar) Arrays.fill(array, Integer.MIN_VALUE);
        return maxValueTopDown(values, weights, values.length, capacity, maxValueSoFar);
//        return maxValueBottomUp(values, weights, capacity);
    }

    private int maxValueRecursive(int[] values, int[] weights, int i, int capacity, int maxValueSoFar) {
        if (i == values.length) {
            return maxValueSoFar;
        }

        if (capacity == 0) {
            return maxValueSoFar;
        }

        if (weights[i] > capacity) {
            return maxValueRecursive(values, weights, i + 1, capacity, maxValueSoFar);
        }

        return Math.max(
                maxValueRecursive(values, weights, i + 1, capacity - weights[i], maxValueSoFar + values[i]),
                maxValueRecursive(values, weights, i + 1, capacity, maxValueSoFar)
        );
    }

    private int maxValueTopDown(int[] values, int[] weights, int i, int capacity, int[][] maxValueSoFar) {
        if (capacity == 0 || i == 0) {
            return 0;
        }

        if (maxValueSoFar[i - 1][capacity - 1] != Integer.MIN_VALUE) {
            return maxValueSoFar[i - 1][capacity - 1];
        }

        if (weights[i - 1] > capacity) {
            return maxValueTopDown(values, weights, i - 1, capacity, maxValueSoFar);
        }

        maxValueSoFar[i - 1][capacity - 1] = Math.max(
                values[i - 1] + maxValueTopDown(values, weights, i - 1, capacity - weights[i - 1], maxValueSoFar),
                maxValueTopDown(values, weights, i - 1, capacity, maxValueSoFar)
        );
        return maxValueSoFar[i - 1][capacity - 1];
    }

    private int maxValueBottomUp(int[] values, int[] weights, int capacity) {
        if (capacity == 0 || values.length == 0) {
            return 0;
        }

        int[][] maxValue = new int[values.length + 1][capacity + 1];
        for (int i = 0; i < maxValue.length; i++) maxValue[i][0] = 0;
        Arrays.fill(maxValue[0], 0);

        for (int i = 1; i <= values.length; i++)
            for (int j = 1; j <= capacity; j++) {
                if (weights[i - 1] > j) {
                    maxValue[i][j] = maxValue[i - 1][j];
                } else {
                    maxValue[i][j] = Math.max(maxValue[i - 1][j], values[i - 1] + maxValue[i - 1][j - weights[i - 1]]);
                }
            }
        return maxValue[values.length][capacity];
    }
}
