package leetcode;

// https://leetcode.com/problems/zigzag-conversion/
public class StringZigzagConversion {
    public String convert(String s, int numRows) {
        if (numRows == 0 || s == null || s.length() == 0) {
            return "";
        }

        if (numRows == 1)
            return s;

        int totalSum = 2 * (numRows - 1);
        StringBuilder answer = new StringBuilder();
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j + i < s.length(); j += totalSum) {
                answer.append(s.charAt(i + j));
                if (i != 0 && i != numRows - 1 && j + totalSum - i < s.length())
                    answer.append(s.charAt(j + totalSum - i));
            }
        }

        return answer.toString();
    }
}
