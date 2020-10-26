package dynamicProgramming;

import java.util.Arrays;

public class BytelandGoldCoinExchange {

    int maxExchangeValue(int goldCoins) {
        int[] maxExchangeValues = new int[goldCoins];
        Arrays.fill(maxExchangeValues, Integer.MIN_VALUE);
        return topDownMaxValue(goldCoins, maxExchangeValues);
    }

    private int topDownMaxValue(int goldCoins, int[] maxExchangeValues) {
        if (goldCoins == 0) {
            return 0;
        }
        if (maxExchangeValues[goldCoins-1] != Integer.MIN_VALUE) {
            return maxExchangeValues[goldCoins-1];
        }
        maxExchangeValues[goldCoins-1] =  Math.max(goldCoins,
                topDownMaxValue(goldCoins / 2, maxExchangeValues) + topDownMaxValue(goldCoins / 3, maxExchangeValues) + topDownMaxValue(goldCoins / 4, maxExchangeValues));
        return maxExchangeValues[goldCoins-1];
    }
}
