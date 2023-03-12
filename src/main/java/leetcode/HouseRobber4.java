package leetcode;


// https://leetcode.com/problems/house-robber-iv/description/
public class HouseRobber4 {
    /*
    Solution approach explanation- (binary search + greedy)
    https://leetcode.com/problems/house-robber-iv/solutions/3143697/java-c-python-binary-search-o-1-space/
    https://leetcode.com/problems/house-robber-iv/solutions/3149864/from-tle-using-dp-to-100-fast-using-binary-search/
    https://leetcode.com/problems/house-robber-iv/solutions/3147277/java-binary-search/
     */
    // Binary search is helpful for mini-max problem like this
    public int minCapability(int[] nums, int k) {
        int low = 0, high = (int) 1e9, answer = 0;
        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (haveAtLeastKHousesForThisValue(mid, nums, k)) {
                answer = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }

        }
        return answer;
    }

    private boolean haveAtLeastKHousesForThisValue(int value, int[] nums, int expectedLeastCount) {
        int takenCount = 0;

        for (int index = 0; index < nums.length; index++) {
            if (nums[index] <= value) {
                takenCount++;
                index++; // Because we have to skip the next house
            }
        }
        return takenCount >= expectedLeastCount;
    }
}
