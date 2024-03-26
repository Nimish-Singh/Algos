package leetcode;

// https://leetcode.com/problems/implement-magic-dictionary/description/
public class MagicDictionary {
    private Trie trie;

    public MagicDictionary() {
        trie = new Trie();
    }

    public void buildDict(String[] dictionary) {
        for (String word : dictionary)
            trie.insert(word);
    }

    public boolean search(String searchWord) {
        return trie.searchWithReplacement(searchWord);
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
        }
    }

    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(String word) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                int index = (int) c - 'a';
                if (temp.children[index] == null)
                    temp.children[index] = new TrieNode();
                temp = temp.children[index];
            }
            temp.isEnd = true;
        }

        public boolean searchWithReplacement(String word) {
            TrieNode temp = root;

            char[] chars = word.toCharArray();
            for (int index = 0; index < chars.length; index++) {
                if (temp == null)
                    return false;

                int j = (int) chars[index] - 'a';
                char original = chars[index];
                for (int i = 0; i < 26; i++) {
                    if (temp.children[i] != null && i == (int) original - 'a')
                        continue;

                    if (temp.children[i] != null) {
                        chars[index] = (char) (i + 97);
                        if (exactSearch(root, new String(chars))) {
                            return true;
                        }
                    }
                }
                chars[index] = original;
                temp = temp.children[j];
            }
            return false;
        }

        private boolean exactSearch(TrieNode root, String word) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                int index = (int) c - 'a';
                if (temp.children[index] == null)
                    return false;
                temp = temp.children[index];
            }
            return temp.isEnd;
        }
    }
}
