package dynamicProgramming;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

// https://leetcode.com/problems/palindromic-substrings/
public class PalindromicSubstrings {
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0)
            return 0;

//        return bruteForce(s);

        Map<Integer, Integer> palindromeMap = new HashMap<>(); // saves count per hash of string
        // surprisingly, the code is faster *without* the usage of map
        return topDownDp(s, palindromeMap);
    }

    private int topDownDp(String string, Map<Integer, Integer> palindromeMap) {
        int length = string.length();
        int count = 1;
        for (int index = 0; index < length - 1; index++) {
            // starting from a point and expanding in both directions as long as characters match
            int oddLengthPalCount = checkPalindromeOddLength(string, index, palindromeMap);
            int evenLengthPalCount = checkPalindromeEvenLength(string, index, palindromeMap);
            count += oddLengthPalCount + evenLengthPalCount;
        }
        return count;
    }

    private int checkPalindromeOddLength(String string, int index, Map<Integer, Integer> palindromeMap) {
        int low = index, high = index, count = 0;
        int key = Objects.hash(string, low, high);
        if (palindromeMap.containsKey(key)) {
            return palindromeMap.get(key);
        }

        while (low >= 0 && high < string.length() && string.charAt(low) == string.charAt(high)) {
            count++;
            low--;
            high++;
        }
        palindromeMap.put(key, count);
        return count;
    }

    private int checkPalindromeEvenLength(String string, int index, Map<Integer, Integer> palindromeMap) {
        int low = index, high = index + 1, count = 0;
        int key = Objects.hash(string, low, high);
        if (palindromeMap.containsKey(key)) {
            return palindromeMap.get(key);
        }

        while (low >= 0 && high < string.length() && string.charAt(low) == string.charAt(high)) {
            count++;
            low--;
            high++;
        }
        palindromeMap.put(key, count);
        return count;
    }

    private int bruteForce(String s) {
        int length = s.length();
        int count = 0;
        for (int start = 0; start < length; start++) {
            for (int end = start + 1; end <= length; end++) {
                if (isPalindrome(s.substring(start, end)))
                    count++;
            }
        }
        return count;
    }

    private boolean isPalindrome(String string) {
        char[] chars = string.toCharArray();
        int low = 0, high = chars.length - 1;

        while (low < high) {
            if (chars[low] != chars[high])
                return false;
            low++;
            high--;
        }
        return true;
    }
}
