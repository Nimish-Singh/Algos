package leetcode;

import java.util.HashMap;
import java.util.Map;

// Given a string, return if it can be divided into two non-empty substrings such that the resulting strings
// can be rearranged to form palindromes after removing at most one character from each.
public class SpecialString {
    public boolean isSpecial(String word) {
        if (word == null || word.length() <= 1)
            return false;

//        return naiveApproach(word);

        return optimisedApproach(word);
    }

    // T=O(n)
    private boolean optimisedApproach(String word) {
        Map<Character, Integer> prefixFrequencyMap = new HashMap<>();
        Map<Character, Integer> suffixFrequencyMap = new HashMap<>();
        for (char character : word.toCharArray())
            suffixFrequencyMap.put(character, suffixFrequencyMap.getOrDefault(character, 0) + 1);

        for (int splitPoint = 0; splitPoint < word.length() - 1; splitPoint++) {
            char character = word.charAt(splitPoint);
            prefixFrequencyMap.put(character, prefixFrequencyMap.getOrDefault(character, 0) + 1);

            if (suffixFrequencyMap.containsKey(character)) {
                suffixFrequencyMap.put(character, suffixFrequencyMap.get(character) - 1);

                if (suffixFrequencyMap.get(character) == 0)
                    suffixFrequencyMap.remove(character);
            }

            if (canMakePalindrome(prefixFrequencyMap) && canMakePalindrome(suffixFrequencyMap))
                return true;
        }

        return false;
    }

    private boolean canMakePalindrome(Map<Character, Integer> frequencyMap) {
        int oddCount = 0;
        for (int frequency : frequencyMap.values())
            if (frequency % 2 != 0)
                oddCount++;

        return oddCount <= 2;
    }

    // T=O(n^2)
    private boolean naiveApproach(String word) {
        for (int splitPoint = 1; splitPoint < word.length(); splitPoint++) {
            String leftPart = word.substring(0, splitPoint);
            String rightPart = word.substring(splitPoint);

            if (canMakePalindrome(leftPart) && canMakePalindrome(rightPart))
                return true;
        }

        return false;
    }

    private boolean canMakePalindrome(String word) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        int oddCount = 0;

        for (char character : word.toCharArray()) {
            frequencyMap.put(character, frequencyMap.getOrDefault(character, 0) + 1);
        }

        for (int frequency : frequencyMap.values())
            if (frequency % 2 != 0)
                oddCount++;

        return oddCount <= 2;
    }
}
