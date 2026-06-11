package leetcode;

import java.util.Stack;

// https://leetcode.com/problems/reverse-substrings-between-each-pair-of-parentheses/description/
public class ReverseSubstrings {
    public String reverseParentheses(String s) {
        Stack<StringBuilder> stack = new Stack<>();
        StringBuilder curr = new StringBuilder();

        for (char c : s.toCharArray()) {

            if (c == '(') {
                stack.push(curr);
                curr = new StringBuilder();
            } else if (c == ')') {
                curr.reverse();

                StringBuilder prev = stack.pop();
                prev.append(curr);

                curr = prev;
            } else {
                curr.append(c);
            }
        }
        return curr.toString();
    }
}
