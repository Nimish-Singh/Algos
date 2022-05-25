package leetcode;

// https://leetcode.com/problems/decode-ways/
public class DecodeWays {
    public int numDecodings(String s) {
//        return recursive(s);

//        int[] memo = new int[s.length() + 1];
//        return topDown(s, 0, memo);

        return bottomUp(s);
    }

    private int bottomUp(String s) {
        if (s.charAt(0) == '0')
            return 0;

        int[] memo = new int[s.length() + 1];
        memo[0] = 1;
        memo[1] = 1;

        for (int index = 2; index <= s.length(); index++) {
            int currentDigit = Integer.parseInt(s.substring(index - 1, index));
            int currentAndPreviousNumber = Integer.parseInt(s.substring(index - 2, index));

            if (currentDigit > 0)
                memo[index] = memo[index - 1];

            if (currentAndPreviousNumber > 9 && currentAndPreviousNumber < 27)
                memo[index] += memo[index - 2];
        }
        return memo[s.length()];
    }

    private int topDown(String s, int index, int[] memo) {
        if (index == s.length())
            return 1;

        if (s.charAt(index) == '0')
            return 0;

        if (index == s.length() - 1)
            return 1;

        if (memo[index] != 0)
            return memo[index];

        int justFirstDigit = 0;
        justFirstDigit = topDown(s, index + 1, memo);
        int firstTwoDigits = 0;

        if (s.length() > 1) {
            int twoDigits = Integer.parseInt(s.substring(index, index + 2));
            if (twoDigits > 9 && twoDigits < 27)
                firstTwoDigits = topDown(s, index + 2, memo);
        }
        memo[index] = justFirstDigit + firstTwoDigits;

        return memo[index];
    }

    private int recursive(String s) {
        if (s == null || s.equals(""))
            return 1;

        if (s.charAt(0) == '0')
            return 0;

        int justFirstDigit = 0;
        justFirstDigit = numDecodings(s.substring(1));
        int firstTwoDigits = 0;

        if (s.length() > 1) {
            int twoDigits = Integer.parseInt(s.substring(0, 2));
            if (twoDigits > 9 && twoDigits < 27)
                firstTwoDigits = numDecodings(s.substring(2));
        }
        return justFirstDigit + firstTwoDigits;
    }
}
