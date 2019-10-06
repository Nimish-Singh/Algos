package subarray;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Optional;

class MaximumSubarraySum {
    SubarrayResult findMaxSumSubarray(int[] array, int lowerIndex, int upperIndex) {
        if (lowerIndex == upperIndex) {
            return new SubarrayResult(lowerIndex, upperIndex, array[lowerIndex]);
        }

        int mid = (lowerIndex + upperIndex) / 2;
        SubarrayResult lowerHalf = findMaxSumSubarray(array, lowerIndex, mid);
        SubarrayResult upperHalf = findMaxSumSubarray(array, mid + 1, upperIndex);
        SubarrayResult crossingSubarray = findMaxCrossingSubArray(array, lowerIndex, upperIndex, mid);

        return lowerHalf.getHigherSum(upperHalf, crossingSubarray);
    }

    private SubarrayResult findMaxCrossingSubArray(int[] array, int lowerIndex, int upperIndex, int mid) {
        int leftSum = Integer.MIN_VALUE;
        int leftIndex = Integer.MIN_VALUE;
        int rightSum = Integer.MIN_VALUE;
        int rightIndex = Integer.MIN_VALUE;
        int sum = 0;

        for (int i = mid; i >= lowerIndex; i--) {
            sum += array[i];
            if (sum > leftSum) {
                leftSum = sum;
                leftIndex = i;
            }
        }

        sum = 0;
        for (int i = mid + 1; i <= upperIndex; i++) {
            sum += array[i];
            if (sum > rightSum) {
                rightSum = sum;
                rightIndex = i;
            }
        }
        return new SubarrayResult(leftIndex, rightIndex, leftSum + rightSum);
    }
}

class SubarrayResult {
    private int lowerIndex, higherIndex, sum;

    SubarrayResult(int lowerIndex, int upperIndex, int sum) {
        this.lowerIndex = lowerIndex;
        this.higherIndex = upperIndex;
        this.sum = sum;
    }

    int getLowerIndex() {
        return lowerIndex;
    }

    int getHigherIndex() {
        return higherIndex;
    }

    int getSum() {
        return sum;
    }

    SubarrayResult getHigherSum(SubarrayResult... others) {
        Optional<SubarrayResult> maxOfOthers = Arrays.stream(others).max(Comparator.comparing(r -> r.sum));
        if (!maxOfOthers.isPresent() || this.sum > maxOfOthers.get().sum) {
            return this;
        }

        return maxOfOthers.get();
    }
}
