package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/lexicographical-numbers/description/
public class LexicographicalNumbers {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> answer = new ArrayList<>();
        Trie root = new Trie();
        for (int i = 1; i <= n; i++) {
            root.insert(i);
        }
        root.getLexicographic(answer);
        return answer;
    }

    private class TrieNode {
        TrieNode[] children;
        boolean isEnd;

        public TrieNode() {
            children = new TrieNode[10];
            isEnd = false;
        }
    }

    private class Trie {
        TrieNode root;

        public Trie() {
            root = new TrieNode();
        }

        public void insert(int num) {
            String word = String.valueOf(num);
            TrieNode temp = root;

            for (char c : word.toCharArray()) {
                int index = c - '0';
                if (temp.children[index] == null)
                    temp.children[index] = new TrieNode();
                temp = temp.children[index];
            }
            temp.isEnd = true;
        }

        public void getLexicographic(List<Integer> answer) {
            helper(root, answer, "");
        }

        private void helper(TrieNode node, List<Integer> answer, String prefix) {
            if (node.isEnd)
                answer.add(Integer.parseInt(prefix));

            for (int i = 0; i < 10; i++)
                if (node.children[i] != null)
                    helper(node.children[i], answer, prefix + i);
        }
    }
}
