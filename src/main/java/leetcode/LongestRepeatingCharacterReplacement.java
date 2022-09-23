package leetcode;

// https://leetcode.com/problems/longest-repeating-character-replacement/
public class LongestRepeatingCharacterReplacement {
    public int characterReplacement(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        if (k >= s.length())
            return s.length();

        int windowStart = 0, mostFrequentChar = 0, maxLength = 0;
        char[] count = new char[26];
        char[] givenChars = s.toCharArray();

        for (int windowEnd = 0; windowEnd < givenChars.length; windowEnd++) {
            int index = givenChars[windowEnd] - 'A';
            count[index]++;
            mostFrequentChar = Math.max(mostFrequentChar, count[index]);

            if (windowEnd - windowStart + 1 - mostFrequentChar > k) {
                count[givenChars[windowStart] - 'A']--;
                windowStart++;
            }
            maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
        }
        return maxLength;
    }
}
