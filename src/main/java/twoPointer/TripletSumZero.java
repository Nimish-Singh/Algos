package twoPointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

// Find the list of triplets in a given unsorted array, which sum up to 0
public class TripletSumZero {
    public List<List<Integer>> searchTriplets(int[] arr) {
        if (arr == null || arr.length == 0)
            return Collections.emptyList();
        int currentIndex = 0;
        Arrays.sort(arr);
        ArrayList<List<Integer>> triplets = new ArrayList<>();
        while (currentIndex < arr.length - 2) {
            searchPairs(arr, -arr[currentIndex], currentIndex + 1, triplets);
            currentIndex++;
        }
        return triplets;
    }

    private void searchPairs(int[] arr, int targetSum, int low, List<List<Integer>> triplets) {
        int high = arr.length - 1;
        while (low < high) {
            if (arr[low] + arr[high] == targetSum) {
                triplets.add(Arrays.asList(-targetSum, arr[low], arr[high]));
                low++;
                high--;
                while (low < high && arr[low] == arr[low - 1])
                    low++;
                while (low < high && arr[high] == arr[high + 1])
                    high--;
                continue;
            }
            if (arr[low] + arr[high] < targetSum)
                low++;
            else
                high--;
        }
    }
}
