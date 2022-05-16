package leetcode;

public class BuySellStock1 {
    public int maxProfit(int[] prices) {
        return linearComplexity(prices);
    }

    private int quadraticComplexity(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int maxProfit = 0;
        for (int buy = 0; buy < prices.length - 1; buy++) {
            for (int sell = buy + 1; sell < prices.length; sell++) {
                maxProfit = Math.max(maxProfit, prices[sell] - prices[buy]);
            }
        }
        return maxProfit;
    }

    private int linearComplexity(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int minBuyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int index = 0; index < prices.length; index++) {
            minBuyPrice = Math.min(minBuyPrice, prices[index]);
            maxProfit = Math.max(maxProfit, prices[index] - minBuyPrice);
        }
        return maxProfit;
    }
}
