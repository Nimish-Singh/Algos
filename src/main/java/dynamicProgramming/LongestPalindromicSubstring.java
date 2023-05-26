package dynamicProgramming;

// Important
// https://leetcode.com/problems/longest-palindromic-substring/
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
//        return naiveApproach(s);

//        return recursive(s, s.length());

//        String[][] memo = new String[s.length()][s.length()];
//        return topDownDp(s, 0, s.length() - 1, memo);

//        return bottomUpDp(s);

        return centresApproach(s);
//        return refactoredCentresApproach(s);
    }

    // https://www.geeksforgeeks.org/longest-palindromic-substring/
    private String bottomUpDp(String s) {
        int length = s.length();
        boolean[][] isPalinMemo = new boolean[length][length];

        // all substrings of length 1 are palindromes
        int maxLength = 1;
        for (int index = 0; index < length; index++)
            isPalinMemo[index][index] = true;

        // check for substring of length 2.
        int start = 0;
        for (int index = 0; index < length - 1; ++index) {
            if (s.charAt(index) == s.charAt(index + 1)) {
                isPalinMemo[index][index + 1] = true;
                maxLength = 2;
                start = index;
            }
        }

        // check for lengths greater than 2
        // outermost loop is the length of substring
        for (int lengthOfStringToCheck = 3; lengthOfStringToCheck <= length; lengthOfStringToCheck++) {

            // fix the starting index
            for (int startIndex = 0; startIndex < length - lengthOfStringToCheck + 1; startIndex++) {

                // get the ending index of substring from. Starting index startIndex and length lengthOfStringToCheck
                int endingIndex = startIndex + lengthOfStringToCheck - 1;

                // checking for sub-string from startIndex index to endingIndex index, if str.charAt(startIndex+1) to
                // str.charAt(endingIndex-1) is a palindrome
                if (isPalinMemo[startIndex + 1][endingIndex - 1]
                    && s.charAt(startIndex) == s.charAt(endingIndex)) {
                    isPalinMemo[startIndex][endingIndex] = true;

                    if (lengthOfStringToCheck > maxLength) {
                        start = startIndex;
                        maxLength = lengthOfStringToCheck;
                    }
                }
            }
        }
        return s.substring(start, start + maxLength);
    }

    private String centresApproach(String s) {
        int maxLength = 0, length;
        String answer = "";

        for (int oddCentre = 0; oddCentre < s.length(); oddCentre++) {
            int low = oddCentre - 1, high = oddCentre + 1;
            while (low > -1 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--; high++;
            }

            length = high - low - 1;
            if (length > maxLength) {
                maxLength = length;
                answer = s.substring(low + 1, high);
            }
        }

        for (int evenCentre = 0; evenCentre < s.length(); evenCentre++) {
            int low = evenCentre, high = evenCentre + 1;
            while (low > -1 && high < s.length() && s.charAt(low) == s.charAt(high)) {
                low--; high++;
            }

            length = high - low - 1;
            if (length > maxLength) {
                maxLength = length;
                answer = s.substring(low + 1, high);
            }
        }

        return answer;
    }

    private String refactoredCentresApproach(String s) {
        int start = 0, end = 0;

        for (int centreIndex = 0; centreIndex < s.length(); centreIndex++) {
            int lengthConsideringOddLength = maxPalindromicLengthAroundCentre(s, centreIndex, centreIndex);
            int lengthConsideringEvenLength = maxPalindromicLengthAroundCentre(s, centreIndex, centreIndex + 1);
            int length = Math.max(lengthConsideringOddLength, lengthConsideringEvenLength);

            if (length > end - start) {
                start = centreIndex - (length - 1) / 2;
                end = centreIndex + length / 2;
            }
        }
        return s.substring(start, end + 1);
    }

    private int maxPalindromicLengthAroundCentre(String s, int centreLeft, int centreRight) {
        int low = centreLeft, high = centreRight;
        while (low > -1 && high < s.length() && s.charAt(low) == s.charAt(high)) {
            low--; high++;
        }
        return high - low - 1;
    }

    private String topDownDp(String s, int start, int end, String[][] memo) {
        if (start > end) {
            return "";
        }

        if (memo[start][end] != null)
            return memo[start][end];

        if (isPalindrome(s.substring(start, end + 1))) {
            memo[start][end] = s.substring(start, end + 1);
            return memo[start][end];
        }

        String lastCharRemoved = topDownDp(s, start, end - 1, memo);
        String firstCharRemoved = topDownDp(s, start + 1, end, memo);

        memo[start][end] = lastCharRemoved.length() > firstCharRemoved.length() ? lastCharRemoved : firstCharRemoved;
        return memo[start][end];
    }

    private String recursive(String s, int length) {
        if (length == 0) {
            return "";
        }

        int start, end, countOfEqualChars = 0;
        for (start = 0, end = length - 1; start < length / 2; start++, end--) {
            if (s.charAt(start) == s.charAt(end))
                countOfEqualChars++;
        }
        if (countOfEqualChars == length / 2) {
            return s;
        }
        String lastCharRemoved = recursive(s.substring(0, length - 1), length - 1);
        String firstCharRemoved = recursive(s.substring(1, length), length - 1);

        return lastCharRemoved.length() > firstCharRemoved.length() ? lastCharRemoved : firstCharRemoved;
    }

    private String naiveApproach(String s) {
        String answer = "";
        int maxLength = 0;

        for (int start = 0; start < s.length(); start++) {
            for (int end = start + 1; end <= s.length(); end++) {
                String substring = s.substring(start, end);
                if (isPalindrome(substring)) {
                    if (maxLength < substring.length()) {
                        maxLength = substring.length();
                        answer = substring;
                    }
                }
            }
        }
        return answer;
    }

    private boolean isPalindrome(String string) {
        int start = 0, end = string.length() - 1;
        while (start <= end) {
            if (string.charAt(start) != string.charAt(end))
                return false;
            start++;
            end--;
        }
        return true;
    }
}
