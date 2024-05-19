package leetcode;

import java.util.ArrayList;
import java.util.List;

// Important - autosuggest feature
// https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestions {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>> answer = new ArrayList<>();

        Trie trie = new Trie();
        for (String p : products)
            trie.insert(p);

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            answer.add(trie.matches(prefix));
        }

        return answer;
    }

    class Trie {
        private TrieNode root = new TrieNode();
        private List<String> ans;

        public void insert(String word) {
            TrieNode temp = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (temp.children[index] == null) {
                    temp.children[index] = new TrieNode();
                }
                temp = temp.children[index];
            }
            temp.isEnd = true;
        }

        public List<String> matches(String word) {
            ans = new ArrayList<>();
            TrieNode temp = root;

            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (temp.children[index] == null)
                    return ans;
                temp = temp.children[index];
            }

            dfsWithPrefix(temp, word);
            return ans;
        }

        private void dfsWithPrefix(TrieNode curr, String word) {
            if (ans.size() == 3)
                return;

            if (curr.isEnd)
                ans.add(word);

            for (int index = 0; index < 26; index++) {
                if (curr.children[index] != null)
                    dfsWithPrefix(curr.children[index], word + (char) (index + 'a'));
            }
        }
    }

    class TrieNode {
        boolean isEnd;
        TrieNode[] children;

        TrieNode() {
            isEnd = false;
            children = new TrieNode[26];
        }
    }
}
