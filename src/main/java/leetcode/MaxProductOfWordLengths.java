package leetcode;

// https://leetcode.com/problems/maximum-product-of-word-lengths/
public class MaxProductOfWordLengths {
    public int maxProduct(String[] words) {
        if (words == null || words.length == 1)
            return 0;

        // https://leetcode.com/problems/maximum-product-of-word-lengths/discuss/76959/JAVA-Easy-Version-To-Understand!!!!!!!!!!!!!!!!!
        // https://www.youtube.com/watch?v=jFeCO8Gxc3k
        int[] bitMasks = new int[words.length];

        for (int index = 0; index < words.length; index++) {
            int mask = 0;
            for (char c : words[index].toCharArray()) {
                // setting those bits which are present
                mask = mask | 1 << (c - 'a');
            }
            bitMasks[index] = mask;
        }

        int answer = 0;
        for (int i = 0; i < words.length; i++) {
            for (int j = i + 1; j < words.length; j++) {
                // if no same bit is set then & will always give 0
                if ((bitMasks[i] & bitMasks[j]) == 0)
                    answer = Math.max(answer, words[i].length() * words[j].length());
            }
        }
        return answer;
    }
}
