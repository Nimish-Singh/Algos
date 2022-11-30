package leetcode;

import java.util.Stack;

import static java.lang.Character.isDigit;

// https://leetcode.com/problems/decode-string/
public class DecodeString {
    public String decodeString(String s) {
        if (s == null || s . length() == 0)
            return "";

        Stack<String> stringStack = new Stack<>();
        Stack<Integer> countStack = new Stack<>();
        char[] sArray = s.toCharArray();

        for (int index = 0; index < sArray.length;) {
            if (isDigit(sArray[index])) {
                String num = "";
                while (index < sArray.length && isDigit(sArray[index])) {
                    num += sArray[index];
                    index++;
                }

                countStack.push(Integer.parseInt(num));
                continue;
            }

            if (sArray[index] == ']') {
                String expression = evaluateExpression(stringStack, countStack);
                stringStack.push(expression);
                index++;
                continue;
            }

            stringStack.push(Character.toString(sArray[index]));
            index++;
        }

        StringBuilder answer = new StringBuilder();
        while (!stringStack.isEmpty()) {
            answer.insert(0, stringStack.pop());
        }
        return answer.toString();
    }

    private String evaluateExpression(Stack<String> stringStack, Stack<Integer> countStack) {
        StringBuilder exp = new StringBuilder();
        while (true) {
            String element = stringStack.pop();

            if ("[".equals(element))
                break;

            exp.insert(0, element);
        }

        StringBuilder answer = new StringBuilder();
        int numberOfRepetitions = countStack.pop();
        for (int iteration = 1; iteration <= numberOfRepetitions; iteration++) {
            answer.append(exp);
        }

        return answer.toString();
    }
}
