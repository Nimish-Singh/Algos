package dynamicProgramming;

// https://leetcode.com/problems/min-cost-climbing-stairs/
public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
//        return Math.min(recursive(0, cost), recursive(1, cost));

        return dpBottomUp(cost);
    }

    private int dpBottomUp(int[] cost) {
        int length = cost.length;
        int[] minCosts = new int[length];
        minCosts[0] = cost[0];
        minCosts[1] = cost[1];

        for (int index = 2; index < length; index++) {
            minCosts[index] = cost[index] + Math.min(minCosts[index - 1], minCosts[index - 2]);
        }
        return Math.min(minCosts[length - 1], minCosts[length - 2]);
    }

    private int recursive(int currentStep, int[] cost) {
        if (currentStep >= cost.length) {
            return 0;
        }
        return cost[currentStep] + Math.min(recursive(currentStep + 1, cost), recursive(currentStep + 2, cost));
    }
}
