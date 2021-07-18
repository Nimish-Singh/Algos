package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

// https://leetcode.com/problems/top-k-frequent-words/
public class KFrequentWords {
    public List<String> topKFrequent(String[] words, int k) {
        Map<String, Integer> frequencyMap = new HashMap<>();

        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }

        PriorityQueue<String> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.get(b) - frequencyMap.get(a) != 0 ? frequencyMap.get(b) - frequencyMap.get(a) : a.compareTo(b));

        frequencyMap.keySet().forEach(maxHeap::offer);

        List<String> kTopFrequent = new ArrayList<>();

        for (int i = 0; i < k; i++) {
            kTopFrequent.add(maxHeap.poll());
        }

        return kTopFrequent;
    }
}
