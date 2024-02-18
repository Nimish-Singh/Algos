package leetcode;

import java.util.Map;
import java.util.HashMap;

// https://leetcode.com/problems/custom-sort-string/description/
public class CustomSortString {
    public String customSortString(String order, String s) {
        Map<String, Integer> frequencyMap = new HashMap();
        StringBuilder answer = new StringBuilder();

        for (char c : s.toCharArray()) {
            String key = String.valueOf(c);
            frequencyMap.put(key, frequencyMap.getOrDefault(key, 0) + 1);
        }

        for (char c : order.toCharArray()) {
            String key = String.valueOf(c);
            if (frequencyMap.containsKey(key)) {
                answer.append(key.repeat(frequencyMap.get(key)));
                frequencyMap.remove(key);
            }
        }

        for (String key : frequencyMap.keySet()) {
            answer.append(key.repeat(frequencyMap.get(key)));
        }

        return answer.toString();
    }
}
