package leetcode;

// https://leetcode.com/problems/longest-word-in-dictionary/description/
public class LongestWordInDictionary {
    private String answer = "";
    public String longestWord(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            insert(root, word);
        }

        traverseTrie(root);
        return answer;
    }

    private void insert(TrieNode root, String word) {
        TrieNode temp = root;
        for (char c : word.toCharArray()) {
            int index = (int)c - 'a';
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();

            temp = temp.children[index];
        }
        temp.word = word;
    }

    private void traverseTrie(TrieNode root) {
        if (root == null)
            return;

        if (root.word != null && root.word.length() >= answer.length()) {
            answer = root.word;
        }

        for (int index = 25; index >= 0; index--) {
            if (root.children[index] != null && root.children[index].word != null)
                traverseTrie(root.children[index]);
        }
    }

    private class TrieNode {
        TrieNode[] children;
        String word;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
