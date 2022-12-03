package leetcode;

// https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
public class LongestSubstringKRepChars {
    public int longestSubstring(String s, int k) {
        if (s == null || s.length() == 0)
            return 0;

        if (k == 0)
            return s.length();

        // https://www.codingninjas.com/codestudio/library/longest-substring-with-at-least-k-repeating-characters
        int uniqueCharsInInput = findUniques(s);
        char[] inputCharsArray = s.toCharArray();
        int answer = 0;

        for (int uniqueCharCountCheck = 1; uniqueCharCountCheck <= uniqueCharsInInput; uniqueCharCountCheck++) {
            int windowStart = 0, windowEnd = 0, charCountWithAtLeastK = 0, uniqueCharsSoFar = 0;
            int[] countMap = new int[26];

            while (windowEnd < inputCharsArray.length) {
                int index;

                if (uniqueCharsSoFar <= uniqueCharCountCheck) {
                    index = inputCharsArray[windowEnd] - 'a';
                    if (countMap[index] == 0)
                        uniqueCharsSoFar++;

                    countMap[index]++;

                    if (countMap[index] == k)
                        charCountWithAtLeastK++;

                    windowEnd++;
                } else {
                    index = inputCharsArray[windowStart] - 'a';
                    if (countMap[index] == k)
                        charCountWithAtLeastK--;

                    countMap[index]--;

                    if (countMap[index] == 0)
                        uniqueCharsSoFar--;

                    windowStart++;
                }
                if (uniqueCharsSoFar == uniqueCharCountCheck && uniqueCharsSoFar == charCountWithAtLeastK)
                    answer = Math.max(answer, windowEnd - windowStart);
            }
        }

        return answer;
    }

    private int findUniques(String input) {
        boolean[] chars = new boolean[26];
        int uniqueCount = 0;

        for (char ch : input.toCharArray()) {
            if (!chars[ch - 'a'])
                uniqueCount++;
            chars[ch - 'a'] = true;
        }
        return uniqueCount;
    }
}
