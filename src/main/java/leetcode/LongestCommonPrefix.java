package leetcode;

import java.util.Arrays;

// https://leetcode.com/problems/longest-common-prefix/description/
public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0)
            return "";

        Arrays.sort(strs);

        int commonPrefixLength = 0;
        for (int index = 0; index < strs[0].length(); index++) {
            if (strs[0].charAt(index) != strs[strs.length - 1].charAt(index))
                break;
            commonPrefixLength++;
        }

        return commonPrefixLength == 0 ? "" : strs[0].substring(0, commonPrefixLength);
    }
}
