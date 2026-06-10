package slidingWindow;

// https://leetcode.com/problems/minimum-window-substring/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        int[] tFreq = new int[128];
        int[] sFreq = new int[128];
        int needed = 0;

        for (char c : t.toCharArray()) {
            if (tFreq[c] == 0)
                needed++;
            tFreq[c]++;
        }

        int minWindow = Integer.MAX_VALUE;
        String answer = "";

        int start = 0, formed = 0;
        char[] sCharArray = s.toCharArray();
        for (int end = 0; end < sCharArray.length; end++) {
            sFreq[sCharArray[end]]++;
            if (sFreq[sCharArray[end]] == tFreq[sCharArray[end]])
                formed++;

            while (formed == needed) {
                if (end - start + 1 < minWindow) {
                    minWindow = end - start + 1;
                    answer = s.substring(start, end + 1);
                }

                if (sFreq[sCharArray[start]] == tFreq[sCharArray[start]])
                    formed--;

                sFreq[sCharArray[start]]--;
                start++;
            }
        }

        return answer;
    }
}
