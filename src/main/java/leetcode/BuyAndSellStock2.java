package leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-ii/
public class BuyAndSellStock2 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int profit = 0;
        for (int index = 0; index < prices.length - 1;) {
            while (index < prices.length - 1 && prices[index] >= prices[index + 1])
                index++;

            int buy = index;

            while (index < prices.length - 1 && prices[index] < prices[index + 1])
                index++;

            int sell = index;

            profit += prices[sell] - prices[buy];
        }
        return profit;
    }
}
