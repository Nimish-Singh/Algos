package dynamicProgramming;

import java.util.Arrays;

// https://leetcode.com/problems/jump-game-ii/
public class JumpGame2 {
    public int jump(int[] nums) {
//        return recursiveHelper(nums, 0);

        int[] minStepsUntilSpecificPoint = new int[nums.length];
        Arrays.fill(minStepsUntilSpecificPoint, -1);
        return bottomUp(nums, 0, minStepsUntilSpecificPoint);
    }

    private int bottomUp(int[] nums, int currentIndex, int[] minStepsUntilSpecificPoint) {
        if (currentIndex >= nums.length - 1) {
            return 0;
        }

        if (minStepsUntilSpecificPoint[currentIndex] != -1)
            return minStepsUntilSpecificPoint[currentIndex];

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[currentIndex]; i++) {
            int recursiveCall = bottomUp(nums, currentIndex + i, minStepsUntilSpecificPoint);
            minSteps = recursiveCall == Integer.MAX_VALUE ?
                    minSteps: Math.min(minSteps, 1 + recursiveCall);
        }
        minStepsUntilSpecificPoint[currentIndex] = minSteps;
        return minStepsUntilSpecificPoint[currentIndex];
    }

    private int recursiveHelper(int[] nums, int currentIndex) {
        if (currentIndex >= nums.length - 1)
            return 0;

        int minSteps = Integer.MAX_VALUE;
        for (int i = 1; i <= nums[currentIndex]; i++) {
            int recursiveCall = recursiveHelper(nums, currentIndex + i);
            minSteps = recursiveCall == Integer.MAX_VALUE ?
                    minSteps: Math.min(minSteps, 1 + recursiveCall); // Else we do 1 + Integer.MAX_VALUE, which overflows
        }
        return minSteps;
    }
}
