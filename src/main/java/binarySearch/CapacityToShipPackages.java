package binarySearch;

// https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/
public class CapacityToShipPackages {
    public int shipWithinDays(int[] weights, int days) {
        int max = 0, sum = 0;
        for (int weight : weights) {
            max = Math.max(max, weight);
            sum += weight;
        }

        int left = max, right = sum, minCapacity = 0;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            int daysNeeded = 1, currentWeight = 0;

            for (int weight : weights) {
                if (currentWeight + weight > mid) {
                    daysNeeded++;
                    currentWeight = 0;
                }
                currentWeight += weight;
            }

            if (daysNeeded > days) {
                left = mid + 1;
            } else
                right = mid - 1;
        }

        return left;
    }
}
