package binarySearch;

class MinimumInRotatedArray {
    int findMinimum(int[] arr) {
        if (arr == null) {
            return Integer.MAX_VALUE;
        }
        int lowerIndex = 0;
        int upperIndex = arr.length - 1;
        int mid;

        while (lowerIndex <= upperIndex) {
            mid = (lowerIndex + upperIndex) / 2;

            if (arr[mid] < arr[mid - 1]) {
                return arr[mid];
            }
            if (arr[mid] > arr[lowerIndex]) {
                lowerIndex = mid + 1;
                continue;
            }
            upperIndex = mid - 1;
        }
        return Integer.MAX_VALUE;
    }
}
