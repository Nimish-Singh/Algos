package binarySearch;

// Given an array of numbers sorted in an ascending order, find the ceiling of a given number
public class Ceiling {
    public int find(int[] arr, int key) {
        int low = 0, high = arr.length - 1, mid;

        if (key > arr[high])
            return -1;

        while (low <= high) {
            mid = low + ((high - low) >> 1);

            if (arr[mid] == key)
                return mid;
            if (arr[mid] < key) {
                low = mid + 1;
                continue;
            }
            high = mid - 1;
        }
        return low;
    }
}
