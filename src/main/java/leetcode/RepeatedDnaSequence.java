package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

// https://leetcode.com/problems/repeated-dna-sequences/
public class RepeatedDnaSequence {
    public List<String> findRepeatedDnaSequences(String s) {
        if (s == null || s.length() < 10)
            return Collections.emptyList();

        Set<String> answer = new HashSet<>();
        Set<String> seen = new HashSet<>();

//        recursive(s, answer, seen);

        iterative(s, answer, seen);
        return new ArrayList<>(answer);
    }

    // No performance difference between either using a Set or a Map for "seen" logic
    private void iterative(String input, Set<String> answer, Set<String> seen) {
        for (int startIndex = 0; startIndex + 10 <= input.length(); startIndex++) {
            String substring = input.substring(startIndex, startIndex + 10);
            if (!seen.contains(substring)) {
                seen.add(substring);
            } else {
                answer.add(substring);
            }
        }
    }

    // T=O(n) Space complexity is high because of recursion stack
    private void recursive(String input, List<String> answer, Map<String, Boolean> seen) {
        if (input.length() < 10)
            return;

        String substring = input.substring(0, 10);

        if (!seen.containsKey(substring)) {
            seen.put(substring, false);
        } else {
            if (!seen.get(substring)) {
                answer.add(substring);
            }
            seen.put(substring, true);
        }

        recursive(input.substring(1), answer, seen);
    }
}
