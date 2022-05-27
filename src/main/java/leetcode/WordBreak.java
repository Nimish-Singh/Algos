package leetcode;

import java.util.List;

// https://leetcode.com/problems/word-break/
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
//        return recursive(s, wordDict);

        return bottomUp(s, wordDict);
    }

    private boolean bottomUp(String s, List<String> wordDict) {
        boolean[] memo = new boolean[s.length() + 1];
        memo[0] = true;

        for (int end = 1; end <= s.length(); end++) {
            for (int start = 0; start < end; start++) {
                if (memo[start] && wordDict.contains(s.substring(start, end))) {
                    memo[end] = true;
                    break;
                }
            }
        }
        return memo[s.length()];
    }

    private boolean recursive(String s, List<String> wordDict) {
        if (s == null || s.equals(""))
            return true;

        for (int index = 1; index <= s.length(); index++) {
            if (wordDict.contains(s.substring(0, index)) && wordBreak(s.substring(index), wordDict))
                return true;
        }
        return false;
    }
}
