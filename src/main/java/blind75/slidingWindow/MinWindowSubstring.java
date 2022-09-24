package blind75.slidingWindow;

import java.util.HashMap;
import java.util.Map;

// https://leetcode.com/problems/minimum-window-substring/
public class MinWindowSubstring {
    public String minWindow(String s, String t) {
        if (t.length() > s.length())
            return "";

        Map<Character, Integer> charCount = new HashMap<>();

        for (char tChar : t.toCharArray())
            charCount.put(tChar, charCount.getOrDefault(tChar, 0) + 1);

        return slidingWindowMethod(s, charCount);
//        return bruteForceMethod(s, charCount);
    }

    private String slidingWindowMethod(String s, Map<Character, Integer> charCount) {
        int windowStart = 0;

        Map<Character, Integer> charCountNeeded = new HashMap<>(charCount);
        Map<Character, Integer> currentChars = new HashMap<>();
        String minSubstring = "";
        int minLength = Integer.MAX_VALUE;
        for (int windowEnd = windowStart; windowEnd < s.length(); windowEnd++) {
            currentChars.put(s.charAt(windowEnd), currentChars.getOrDefault(s.charAt(windowEnd), 0) + 1);

            if (charCountNeeded.containsKey(s.charAt(windowEnd))) {
                Integer currentCount = charCountNeeded.get(s.charAt(windowEnd));
                if (currentCount == 1)
                    charCountNeeded.remove(s.charAt(windowEnd));
                else
                    charCountNeeded.put(s.charAt(windowEnd), currentCount - 1);
            }

            if (charCountNeeded.isEmpty()) {
                while (windowStart < windowEnd && (!charCount.containsKey(s.charAt(windowStart)) || charCount.get(s.charAt(windowStart)) < currentChars.get(s.charAt(windowStart)))) {
                    currentChars.put(s.charAt(windowStart), currentChars.get(s.charAt(windowStart)) - 1);
                    windowStart++;
                }

                if (minLength > windowEnd - windowStart + 1) {
                    minSubstring = s.substring(windowStart, windowEnd + 1);
                    minLength = minSubstring.length();
                }
                currentChars.put(s.charAt(windowStart), currentChars.get(s.charAt(windowStart)) - 1);
                if (charCount.containsKey(s.charAt(windowStart)))
                    charCountNeeded.put(s.charAt(windowStart), 1);
                windowStart++;
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : minSubstring;
    }

    private String bruteForceMethod(String s, Map<Character, Integer> charCount) {
        String minSubstring = s;
        int minLength = Integer.MAX_VALUE;
        for (int startIndex = 0; startIndex < s.length(); startIndex++) {
            Map<Character, Integer> charCountNeeded = new HashMap<>(charCount);
            for (int endIndex = startIndex; endIndex < s.length(); endIndex++) {
                if (charCountNeeded.containsKey(s.charAt(endIndex))) {
                    Integer currentCount = charCountNeeded.get(s.charAt(endIndex));
                    if (currentCount == 1)
                        charCountNeeded.remove(s.charAt(endIndex));
                    else
                        charCountNeeded.put(s.charAt(endIndex), currentCount - 1);
                }

                if (charCountNeeded.isEmpty()) {
                    if (minLength > endIndex - startIndex + 1) {
                        minSubstring = s.substring(startIndex, endIndex + 1);
                        minLength = minSubstring.length();
                    }
                }
            }
        }
        return minLength == Integer.MAX_VALUE ? "" : minSubstring;
    }
}
