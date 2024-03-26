package leetcode;

// https://leetcode.com/problems/number-of-matching-subsequences/description/
public class MatchingSubsequences {
    public int numMatchingSubseq(String s, String[] words) {
        Trie trie = new Trie();
        for (String word : words)  {
            trie.insert(word);
        }

        return trie.helper(s);
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        int count;

        public TrieNode() {
            children = new TrieNode[26];
            isEnd = false;
            count = 0;
        }
    }

    private class Trie {
        private TrieNode root;
        private int answer;

        public Trie() {
            root = new TrieNode();
            answer = 0;
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
            temp.count++;
        }


        public int helper(String s) {
            search(s, root, -1);
            return answer;
        }

        private void search(String s, TrieNode node, int lastIndex) {
            if (node.isEnd)
                answer += node.count;
            for (int i = 0; i < 26; i++) {
                if (node.children[i] != null) {
                    char c = (char)(i + 'a');
                    int nextIndex = findIndex(s, c, lastIndex + 1);
                    if (nextIndex != -1)
                        search(s, node.children[i], nextIndex);
                }
            }
        }

        private int findIndex(String s, char c, int index) {
            for (int i = index; i < s.length(); i++) {
                if (s.charAt(i) == c)
                    return i;
            }
            return -1;
        }
    }
}
