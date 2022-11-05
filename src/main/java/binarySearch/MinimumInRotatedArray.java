package binarySearch;

// Important
// https://leetcode.com/problems/find-minimum-in-rotated-sorted-array
class MinimumInRotatedArray {
    int findMinimum(int[] arr) {
        if (arr == null) {
            return Integer.MAX_VALUE;
        }
        int lowerIndex = 0;
        int upperIndex = arr.length - 1;
        int mid = 0;

        if (arr[lowerIndex] < arr[upperIndex])
            return arr[0];

        while (lowerIndex <= upperIndex) {
            mid = lowerIndex + (upperIndex - lowerIndex) / 2;

            if (arr[mid] > arr[mid + 1])
                return arr[mid + 1];

            if (arr[mid] < arr[mid - 1])
                return arr[mid];

            if (arr[mid] < arr[0])
                upperIndex = mid - 1;
            else
                lowerIndex = mid + 1;
        }
        return Integer.MAX_VALUE;
    }
}
