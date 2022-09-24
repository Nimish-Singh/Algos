package blind75.twoPointer;

import static java.lang.Character.*;

// https://leetcode.com/problems/valid-palindrome/
public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;
        char[] chars = s.toCharArray();

        while (low < high) {
            while (low < high && !isLetterOrDigit(chars[low]))
                low++;
            while (low < high && !isLetterOrDigit(chars[high]))
                high--;

            if (toLowerCase(chars[low]) != toLowerCase(chars[high]))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
