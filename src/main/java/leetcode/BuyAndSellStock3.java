package leetcode;

// https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
public class BuyAndSellStock3 {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0)
            return 0;

        int profitAfterFirstBuy = Integer.MIN_VALUE, profitAfterFirstSell = 0;
        int profitAfterSecondBuy = Integer.MIN_VALUE, profitAfterSecondSell = 0;

        for (int index = 0; index < prices.length; index++) {
            profitAfterFirstBuy = Math.max(profitAfterFirstBuy, -prices[index]);
            profitAfterFirstSell = Math.max(profitAfterFirstSell, prices[index] + profitAfterFirstBuy);
            profitAfterSecondBuy = Math.max(profitAfterSecondBuy, profitAfterFirstSell - prices[index]);
            profitAfterSecondSell = Math.max(profitAfterSecondSell, profitAfterSecondBuy + prices[index]);
        }
        return profitAfterSecondSell;
    }
}
