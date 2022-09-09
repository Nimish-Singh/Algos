package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/check-if-a-string-can-break-another-string/
public class StringPermutationBreak {
    public boolean checkIfCanBreak(String s1, String s2) {
//        return sortingApproach(s1, s2);
        return bucketCountingApproach(s1, s2);
    }

    private boolean sortingApproach(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();

        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        char[] lower = s1Chars;
        char[] higher = s2Chars;

        int equalCharsIndex = 0;
        while (equalCharsIndex < lower.length && lower[equalCharsIndex] == higher[equalCharsIndex]) {
            equalCharsIndex++;
        }
        if (lower[equalCharsIndex] > higher[equalCharsIndex]) {
            lower = s2Chars;
            higher = s1Chars;
        }

        for (int index = 0; index < lower.length; index++) {
            if (lower[index] > higher[index])
                return false;
        }
        return true;
    }

    private boolean bucketCountingApproach(String s1, String s2) {
        char[] s1Chars = new char[26];
        char[] s2Chars = new char[26];
        for (int index = 0; index < s1.length(); index++) {
            s1Chars[s1.charAt(index) - 'a']++;
            s2Chars[s2.charAt(index) - 'a']++;
        }

        boolean isS1Smaller = false, isS2Smaller = false;
        int countS1 = 0, countS2 = 0;

        for (int index = 0; index < 26; index++) {
            countS1 += s1Chars[index];
            countS2 += s2Chars[index];

            if (countS1 > countS2) {
                if (isS2Smaller)
                    return false;
                isS1Smaller = true;
            } else if (countS2 > countS1) {
                if (isS1Smaller)
                    return false;
                isS2Smaller = true;
            }
        }

        return true;
    }
}
