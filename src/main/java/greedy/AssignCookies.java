package greedy;

import java.util.Arrays;

// https://leetcode.com/problems/assign-cookies/
public class AssignCookies {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int count = 0;

        for (int index = 0; index < s.length && count < g.length; index++) {
            if (s[index] >= g[count])
                count++;
        }
        return count;
    }
}
