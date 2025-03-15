package binarySearch;

// https://leetcode.com/problems/maximum-candies-allocated-to-k-children/description/
public class MaxCandies {
    public int maximumCandies(int[] candies, long k) {
        int maxCandies = 0;
        for (int pile : candies)
            maxCandies = Math.max(maxCandies, pile);

        int low = 0, high = maxCandies;

        while (low < high) {
            int mid = low + (high - low) / 2 + 1;

            if (canAllocateToAll(candies, k, mid))
                low = mid;
            else
                high = mid - 1;
        }

        return low;
    }

    private boolean canAllocateToAll(int[] candies, long k, int mid) {
        long kidsServiceable = 0;
        for (int pile : candies)
            kidsServiceable += pile / mid;

        return kidsServiceable >= k;
    }
}
