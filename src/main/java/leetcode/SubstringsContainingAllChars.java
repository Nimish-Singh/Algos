package leetcode;

// https://leetcode.com/problems/number-of-substrings-containing-all-three-characters/description/
public class SubstringsContainingAllChars {
    public int numberOfSubstrings(String s) {
        int length = s.length();
        int[] letterCounts = new int[3];
        int answer = 0;

        int windowStart = 0, windowEnd = 0;

        while (windowEnd < length) {
            letterCounts[s.charAt(windowEnd) - 'a']++;
            while (allCharsContained(letterCounts)) {
                answer += length - windowEnd;

                letterCounts[s.charAt(windowStart) - 'a']--;
                windowStart++;
            }
            windowEnd++;
        }

        return answer;
    }

    private boolean allCharsContained(int[] letterCounts) {
        return letterCounts[0] > 0 && letterCounts[1] > 0 && letterCounts[2] > 0;
    }
}
