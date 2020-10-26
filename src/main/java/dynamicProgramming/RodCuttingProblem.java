package dynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RodCuttingProblem {
    private int[] prices = {1, 5, 8, 9, 10, 17, 17, 20, 24, 30};

    public int maximumProfitRecursive(int rodLength) {
        if (rodLength <= 0) {
            return 0;
        }
        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= rodLength; i++) {
            maxProfit = Math.max(maxProfit, prices[i - 1] + maximumProfitRecursive(rodLength - i));
        }
        return maxProfit;
    }

    public int maximumProfitTopDown(int rodLength) {
        int[] maxProfits = new int[rodLength];
        Arrays.fill(maxProfits, Integer.MIN_VALUE);
        return topDownApproach(rodLength, maxProfits);
    }

    private int topDownApproach(int rodLength, int[] maxProfits) {
        if (rodLength == 0) {
            return 0;
        }

        if (maxProfits[rodLength - 1] >= 0) {
            return maxProfits[rodLength - 1];
        }

        int maxProfit = Integer.MIN_VALUE;
        for (int i = 1; i <= rodLength; i++) {
            maxProfit = Math.max(maxProfit, prices[i - 1] + topDownApproach(rodLength - i, maxProfits));
        }
        maxProfits[rodLength - 1] = maxProfit;
        return maxProfit;
    }

    public int maximumProfitBottomUp(int rodLength) {
        int[] maxProfits = new int[rodLength + 1];
        maxProfits[0] = 0;

        for (int index = 1; index < maxProfits.length; index++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int cut = 1; cut <= index; cut++) {
                maxProfit = Math.max(maxProfit, prices[cut - 1] + maxProfits[index - cut]);
            }
            maxProfits[index] = maxProfit;
        }
        return maxProfits[rodLength];
    }

    public List<Integer> cutSizesUsingBottomUpApproach(int rodLength) {
        int[] maxProfits = new int[rodLength + 1];
        maxProfits[0] = 0;
        int[] optimumCuts = new int[rodLength + 1];
        optimumCuts[0] = 0;

        for (int index = 1; index <= rodLength; index++) {
            int maxProfit = Integer.MIN_VALUE;
            for (int cut = 1; cut <= index; cut++) {
                if (maxProfit < prices[cut - 1] + maxProfits[index - cut]) {
                    maxProfit = prices[cut - 1] + maxProfits[index - cut];
                    optimumCuts[index] = cut;
                }
            }
            maxProfits[index] = maxProfit;
        }
        List<Integer> cuts = new ArrayList<>();
        for (int i = rodLength; i > 0; i -= optimumCuts[i]) {
            cuts.add(optimumCuts[i]);
        }
        return cuts;
    }
}
