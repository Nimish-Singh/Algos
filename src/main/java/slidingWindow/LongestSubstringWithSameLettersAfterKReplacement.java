package slidingWindow;

// Given a string with lowercase letters only, if you are allowed to replace no more than ‘k’ letters with any letter,
// find the length of the longest substring having the same letters after replacement.
public class LongestSubstringWithSameLettersAfterKReplacement {
    int findLength(String str, int k) {
        if (str == null || str.length() == 0)
            return 0;
        int[] charCount = new int[26];
        int windowStart = 0, maxCharCount = Integer.MIN_VALUE, maxLength = 0;

        char[] chars = str.toCharArray();
        for (int windowEnd = 0; windowEnd < chars.length; windowEnd++) {
            charCount[chars[windowEnd] - 'a']++;
            maxCharCount = Math.max(maxCharCount, charCount[chars[windowEnd] - 'a']);

            if (windowEnd - windowStart + 1 - maxCharCount <= k)
                maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
            else{
                charCount[chars[windowStart] - 'a']--;
                windowStart++;
            }
        }
        return maxLength;
    }
}
