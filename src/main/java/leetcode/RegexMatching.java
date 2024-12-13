package leetcode;

// https://leetcode.com/problems/regular-expression-matching/
public class RegexMatching {
    public boolean isMatch(String s, String p) {
//        return recursive(s, p);

        Boolean[][] memo = new Boolean[s.length()][p.length()];
        return topDown(s, p, memo, 0, 0);

//        return bottomUp(s.toCharArray(), p.toCharArray());
    }

    private boolean recursive(String text, String pattern) {
        if (pattern.isEmpty())
            return text.isEmpty();

        boolean firstMatch = !text.isEmpty() && (pattern.charAt(0) == text.charAt(0) || pattern.charAt(0) == '.');

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return recursive(text, pattern.substring(2)) || (firstMatch && recursive(text.substring(1), pattern));
        }

        return firstMatch && recursive(text.substring(1), pattern.substring(1));
    }

    // https://stackoverflow.com/questions/49572289/understanding-regex-string-matching-using-dynamic-programming
    private boolean topDown(String text, String pattern, Boolean[][] memo, int textIndex, int patternIndex) {
        if (patternIndex == pattern.length())
            return textIndex == text.length();

        if (textIndex == text.length()) {
            return pattern.length() >= patternIndex + 2 && pattern.charAt(patternIndex + 1) == '*' && topDown(text, pattern, memo, textIndex, patternIndex + 2);
        }

        if (memo[textIndex][patternIndex] != null)
            return memo[textIndex][patternIndex];

        boolean firstMatch = pattern.charAt(patternIndex) == text.charAt(textIndex) || pattern.charAt(patternIndex) == '.';

        if (pattern.length() >= patternIndex + 2 && pattern.charAt(patternIndex + 1) == '*') {
            memo[textIndex][patternIndex] = topDown(text, pattern, memo, textIndex, patternIndex + 2) || (firstMatch && topDown(text, pattern, memo, textIndex + 1, patternIndex));
            return memo[textIndex][patternIndex];
        }

        memo[textIndex][patternIndex] = firstMatch && topDown(text, pattern, memo, textIndex + 1, patternIndex + 1);
        return memo[textIndex][patternIndex];
    }

    // https://www.youtube.com/watch?v=l3hda49XcDE
    private boolean bottomUp(char[] text, char[] pattern) {
        boolean[][] memo = new boolean[text.length + 1][pattern.length + 1];
        memo[0][0] = true;

        // deals with patterns like a* or a*b* or a*b*c*
        for (int column = 1; column < memo[0].length; column++) {
            if (pattern[column - 1] == '*')
                memo[0][column] = memo[0][column - 2];
        }

        for (int textIndex = 1; textIndex < memo.length; textIndex++) {
            for (int patternIndex = 1; patternIndex < memo[0].length; patternIndex++) {
                if (pattern[patternIndex - 1] == '.' || pattern[patternIndex - 1] == text[textIndex - 1])
                    memo[textIndex][patternIndex] = memo[textIndex - 1][patternIndex - 1];
                else if (pattern[patternIndex - 1] == '*') {
                    memo[textIndex][patternIndex] = memo[textIndex][patternIndex - 2];

                    if (pattern[patternIndex - 2] == '.' || pattern[patternIndex - 2] == text[textIndex - 1])
                        memo[textIndex][patternIndex] = memo[textIndex][patternIndex] || memo[textIndex - 1][patternIndex];
                } else
                    memo[textIndex][patternIndex] = false;
            }
        }

        return memo[text.length][pattern.length];
    }
}
