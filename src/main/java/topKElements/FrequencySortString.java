package topKElements;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
// Important
// Given a string, sort it based on the decreasing frequency of its characters
public class FrequencySortString {
    public String transform(String str) {
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (char character : str.toCharArray())
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);

        PriorityQueue<Character> maxHeap = new PriorityQueue<>((a, b) -> frequencyMap.getOrDefault(b, 0) - frequencyMap.getOrDefault(a, 0));

        maxHeap.addAll(frequencyMap.keySet());
        StringBuilder result = new StringBuilder(str.length());
        while (!maxHeap.isEmpty()) {
            Character character = maxHeap.poll();

            for (int i = 0; i < frequencyMap.get(character); i++)
                result.append(character);
        }
        return result.toString();
    }
}
