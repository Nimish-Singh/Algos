package slidingWindow;

// Given a string, find the length of the longest substring in it with no more than K distinct characters.
public class LongestSubstringWithNoMoreThanKDistinctChars {
    int findLength(String str, int k) {
        int maxLength = Integer.MIN_VALUE, windowStart = 0, uniqueCount = 0;
        for (int windowEnd = 0; windowEnd < str.length();) {
            int indexOfCurrentChar = str.substring(windowStart, windowEnd).indexOf(str.charAt(windowEnd));
            if (indexOfCurrentChar == -1 && uniqueCount < k) {
                maxLength = Integer.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
                uniqueCount++;
            } else if (indexOfCurrentChar != -1) {
                maxLength = Integer.max(maxLength, windowEnd - windowStart + 1);
                windowEnd++;
            } else {
                windowEnd++;
                windowStart++;
            }
        }
        return maxLength;
    }
}
