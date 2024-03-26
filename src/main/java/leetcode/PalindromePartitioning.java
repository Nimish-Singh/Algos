package leetcode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

// https://leetcode.com/problems/palindrome-partitioning/description/
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        if (s == null || s.length() == 0)
            return Collections.emptyList();

        List<List<String>> answer = new ArrayList<>();
        helper(s, new LinkedList<>(), answer);
        return answer;
    }

    private void helper(String s, List<String> step, List<List<String>> answer) {
        if (s == null || s.length() == 0) {
            answer.add(new ArrayList<>(step));
            return;
        }

        for (int index = 1; index <= s.length(); index++) {
            String temp = s.substring(0, index);
            if (!isPalindrome(temp))
                continue;

            step.add(temp);
            helper(s.substring(index, s.length()), step, answer);
            step.remove(step.size() - 1);
        }
    }

    private boolean isPalindrome(String s) {
        int low = 0, high = s.length() - 1;

        while (low <= high) {
            if (s.charAt(low) != s.charAt(high))
                return false;
            low++;
            high--;
        }
        return true;
    }
}
