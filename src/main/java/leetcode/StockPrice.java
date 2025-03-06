package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

// https://leetcode.com/problems/stock-price-fluctuation/description/
public class StockPrice {
    private Map<Integer, Integer> timestampPriceMap;

    /* A count here ensures that, say, if we previously had 100 twice and 1 of those 100 was corrected to 300,
    then we would still have one 100 to correctly compute max/min
     */
    private TreeMap<Integer, Integer> priceCount;

    private int latestTimestamp;

    public StockPrice() {
        timestampPriceMap = new HashMap<>();
        priceCount = new TreeMap<>();
        latestTimestamp = 0;
    }

    public void update(int timestamp, int price) {
        if (timestampPriceMap.containsKey(timestamp)) {
            int oldPrice = timestampPriceMap.get(timestamp);
            priceCount.put(oldPrice, priceCount.get(oldPrice) - 1);
            if (priceCount.get(oldPrice) == 0) {
                priceCount.remove(oldPrice);
            }
        }

        timestampPriceMap.put(timestamp, price);
        priceCount.put(price, priceCount.getOrDefault(price, 0) + 1);
        latestTimestamp = Math.max(latestTimestamp, timestamp);
    }

    public int current() {
        return timestampPriceMap.get(latestTimestamp);
    }

    public int maximum() {
        return priceCount.lastKey();
    }

    public int minimum() {
        return priceCount.firstKey();
    }
}
