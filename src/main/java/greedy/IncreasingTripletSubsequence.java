package greedy;

// https://leetcode.com/problems/increasing-triplet-subsequence/
public class IncreasingTripletSubsequence {
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;

        for (int number : nums) {
            // Update is this is the smallest so far
            if (number <= smallest) {
                smallest = number;
                continue;
            }
            // If not the smallest, then update if this is the second smallest
            if (number <= middle) {
                middle = number;
                continue;
            }
            // At this stage, we have found the number larger than 2 previous ones, so subsequence is present
            return true;
        }
        return false;
    }
}
