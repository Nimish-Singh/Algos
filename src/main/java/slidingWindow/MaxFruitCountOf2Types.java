package slidingWindow;

import java.util.HashMap;
import java.util.Map;

// Given an array of characters where each character represents a fruit tree, you are given two baskets and your goal is to put maximum number of fruits in each basket. The only restriction is that each basket can have only one type of fruit.
// You can start with any tree, but once you have started you can’t skip a tree. You will pick one fruit from each tree until you cannot, i.e., you will stop when you have to pick from a third fruit type.
public class MaxFruitCountOf2Types {
    int findTotal(char[] arr) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int windowStart = 0, maxTotal = Integer.MIN_VALUE;

        for (int windowEnd = 0; windowEnd < arr.length; windowEnd++) {
            frequencyMap.put(arr[windowEnd], frequencyMap.getOrDefault(arr[windowEnd], 0) + 1);

            while (frequencyMap.size() > 2) {
                frequencyMap.put(arr[windowStart], frequencyMap.get(arr[windowStart]) - 1);
                if (frequencyMap.get(arr[windowStart]) == 0)
                    frequencyMap.remove(arr[windowStart]);
                windowStart++;
            }
            maxTotal = Math.max(maxTotal, windowEnd - windowStart + 1);
        }
        return maxTotal;
    }
}
