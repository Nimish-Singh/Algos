package leetcode;

// https://leetcode.com/problems/map-sum-pairs/description/
public class MapSum {
    private Trie trie;

    public MapSum() {
        trie = new Trie();
    }

    public void insert(String key, int val) {
        trie.insert(key, val);
    }

    public int sum(String prefix) {
        return trie.sum(prefix);
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        int value;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
            value = 0;
        }
    }

    private class Trie {
        private TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert (String word, int val) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                int index = getIndex(c);
                if (temp.children[index] == null)
                    temp.children[index] = new TrieNode();
                temp = temp.children[index];
            }
            temp.isEnd = true;
            temp.value = val;
        }

        public int sum(String prefix) {
            TrieNode temp = root;

            for (char c : prefix.toCharArray()) {
                int index = getIndex(c);
                if (temp.children[index] == null)
                    return 0;

                temp = temp.children[index];
            }

            if (temp == null)
                return 0;

            return dfs(temp);
        }

        private int dfs(TrieNode node) {
            int sum = node.value;
            for (TrieNode child : node.children) {
                if (child != null)
                    sum += dfs(child);
            }
            return sum;
        }

        private int getIndex(char c) {
            return (int) c - 'a';
        }
    }
}
