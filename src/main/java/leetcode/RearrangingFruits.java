package leetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeMap;

// https://leetcode.com/problems/rearranging-fruits/description/
public class RearrangingFruits {
    // https://leetcode.com/problems/rearranging-fruits/solutions/3143917/java-c-python-two-ways-to-swap/
    public long minCost(int[] basket1, int[] basket2) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        for (int fruit : basket1) {
            frequencyMap.merge(fruit, 1, Integer::sum);
        }
        for (int fruit : basket2) {
            frequencyMap.merge(fruit, -1, Integer::sum);
        }

        List<Integer> swapsNeeded = new ArrayList<>();
        long answer = 0, smallestElement = frequencyMap.firstKey();

        for (int fruit : frequencyMap.keySet()) {
            if (frequencyMap.get(fruit) % 2 != 0)
                return -1;

            int halfOfFrequency = Math.abs(frequencyMap.get(fruit)) / 2;

            // adding these many times, the element to be swapped
            for (int index = 0; index < halfOfFrequency; index++) {
                swapsNeeded.add(fruit);
            }
        }

        // Because 1 swap means putting 2 elements in place
        for (int index = 0; index < swapsNeeded.size() / 2; index++) {
            answer += Math.min(swapsNeeded.get(index), smallestElement * 2);
        }

        return answer;
    }
}
