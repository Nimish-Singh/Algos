package binarySearch;

class ElementOccurence {
    int count(int[] arr, int numberToCount) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int firstIndex = findIndex(arr, numberToCount, true);
        int lastIndex = findIndex(arr, numberToCount, false);
        return firstIndex == -1 ? 0 : lastIndex - firstIndex + 1;
    }

    private int findIndex(int[] arr, int numberToCount, boolean shouldFindFirst) {
        int lowerIndex = 0;
        int upperIndex = arr.length - 1;
        int index = -1;

        while (lowerIndex <= upperIndex) {
            int mid = (lowerIndex + upperIndex) / 2;
            if (arr[mid] < numberToCount) {
                lowerIndex = mid + 1;
                continue;
            }
            if (arr[mid] > numberToCount) {
                upperIndex = mid - 1;
                continue;
            }

            index = mid;
            if (shouldFindFirst) {
                upperIndex = mid - 1;
            } else {
                lowerIndex = mid + 1;
            }
        }
        return index;
    }
}
