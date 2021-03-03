package slidingWindow;

// Given a string, find the length of the longest substring which has no repeating characters.
public class LongestNonRepeatingCharacterSubstring {
    int findLength(String str) {
        int maxLength = Integer.MIN_VALUE, windowStart = 0;
        for (int windowEnd = 0; windowEnd < str.length(); windowEnd++) {
            while (str.substring(windowStart, windowEnd).indexOf(str.charAt(windowEnd)) != -1)
                windowStart++;
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
