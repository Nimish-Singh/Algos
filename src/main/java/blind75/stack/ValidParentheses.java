package blind75.stack;

import java.util.Stack;

// https://leetcode.com/problems/valid-parentheses/
public class ValidParentheses {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        for (char symbol : s.toCharArray()) {
            if (symbol == '(' || symbol == '[' || symbol == '{') {
                stack.push(symbol);
                continue;
            }

            if (symbol == ')' && (stack.isEmpty() || stack.pop() != '(')) {
                return false;
            }
            if (symbol == '}' && (stack.isEmpty() || stack.pop() != '{')) {
                return false;
            }
            if (symbol == ']' && (stack.isEmpty() || stack.pop() != '[')) {
                return false;
            }
        }
        return stack.isEmpty();
    }
}
