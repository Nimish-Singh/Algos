package leetcode;

// https://leetcode.com/problems/left-and-right-sum-differences/description/
public class LeftAndRightSumDifference {
    public int[] leftRightDifference(int[] nums) {
        int[] leftSums = new int[nums.length];
        leftSums[0] = 0;
        for (int index = 1; index < leftSums.length; index++) {
            leftSums[index] = leftSums[index - 1] + nums[index - 1];
        }

        int[] rightSums = new int[nums.length];
        rightSums[rightSums.length - 1] = 0;
        for (int index = rightSums.length - 2; index >= 0; index--) {
            rightSums[index] = rightSums[index + 1] + nums[index + 1];
        }

        int[] answer = new int[nums.length];
        for (int index = 0; index < nums.length; index++) {
            answer[index] = Math.abs(leftSums[index] - rightSums[index]);
        }
        return answer;
    }
}
