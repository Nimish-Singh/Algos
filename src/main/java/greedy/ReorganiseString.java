package greedy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

// https://leetcode.com/problems/reorganize-string/
public class ReorganiseString {
    public String reorganizeString(String s) {
        if (s.length() == 1) {
            return s;
        }

        Map<Character, Integer> letterFrequencies = new HashMap<>();
        for (char letter : s.toCharArray()) {
            letterFrequencies.put(letter, letterFrequencies.getOrDefault(letter, 0) + 1);
        }

        Queue<Character> maxHeap = new PriorityQueue<>((a, b) -> letterFrequencies.get(a).equals(letterFrequencies.get(b)) ? a - b : letterFrequencies.get(b) - letterFrequencies.get(a));
        maxHeap.addAll(letterFrequencies.keySet());

        StringBuilder answer = new StringBuilder();

        for (int index = 0; index < s.length(); index++) {
            Set<Character> polledCharacters = new HashSet<>();
            while (!maxHeap.isEmpty() && answer.length() != 0 && Objects.equals(maxHeap.peek(), answer.charAt(index - 1))) {
                polledCharacters.add(maxHeap.poll());
            }

            if (maxHeap.isEmpty()) {
                return "";
            }

            Character characterToAdd = maxHeap.poll();
            answer.append(characterToAdd);
            if (letterFrequencies.get(characterToAdd) != 1) {
                letterFrequencies.put(characterToAdd, letterFrequencies.get(characterToAdd) - 1);
                maxHeap.offer(characterToAdd);
            }

            maxHeap.addAll(polledCharacters);
        }
        return answer.toString();
    }
}
