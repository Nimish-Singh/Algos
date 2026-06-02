package slidingWindow;

import java.util.*;

// https://leetcode.com/problems/find-all-anagrams-in-a-string/description/
public class FindAllAnagrams {
    public List<Integer> findAnagrams(String s, String p) {
        int[] pCharCount = new int[26];

        for (char c : p.toCharArray()) {
            pCharCount[c - 'a']++;
        }

        int windowStart = 0;
        List<Integer> answer = new ArrayList<>();

        int[] sCharCount = new int[26];
        for (int windowEnd = 0; windowEnd < s.length(); windowEnd++) {
            char c = s.charAt(windowEnd);
            sCharCount[c - 'a']++;

            if (windowEnd - windowStart + 1 > p.length()) {
                while (windowEnd - windowStart + 1 > p.length()) {
                    char toRemove = s.charAt(windowStart);
                    sCharCount[toRemove - 'a']--;
                    windowStart++;
                }
            }

            if (windowEnd - windowStart + 1 == p.length()) {
                if (Arrays.equals(pCharCount, sCharCount)) {
                    answer.add(windowStart);
                }
            }
        }

        return answer;
    }
}
