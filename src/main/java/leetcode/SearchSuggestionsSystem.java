package leetcode;

import java.util.ArrayList;
import java.util.List;

// https://leetcode.com/problems/search-suggestions-system/
public class SearchSuggestionsSystem {
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie trie = new Trie();
        for (String product : products)
            trie.insert(product);
        List<List<String>> answer = new ArrayList<>();

        String prefix = "";
        for (char c : searchWord.toCharArray()) {
            prefix += c;
            answer.add(trie.getWordsStartingWithPrefix(prefix));
        }

        return answer;
    }
}

class Trie {
    private TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    public void insert (String word) {
        TrieNode temp = root;

        for (char c : word.toCharArray()) {
            int index = getIndex(c);
            if (temp.children[index] == null)
                temp.children[index] = new TrieNode();
            temp = temp.children[index];
        }
        temp.isEnd = true;
    }

    public List<String> getWordsStartingWithPrefix(String prefix) {
        TrieNode temp = root;
        List<String> answer = new ArrayList<>();

        for (char c : prefix.toCharArray()) {
            int index = getIndex(c);
            if (temp.children[index] == null)
                return answer;
            temp = temp.children[index];
        }

        dfsWithPrefix(temp, prefix, answer);
        return answer;
    }

    private void dfsWithPrefix(TrieNode node, String word, List<String> answer) {
        if (answer.size() == 3)
            return;

        if (node.isEnd)
            answer.add(word);

        for (char c = 'a'; c <= 'z'; c++) {
            int index = getIndex(c);
            if (node.children[index] != null)
                dfsWithPrefix(node.children[index], word + c, answer);
        }
    }

    private int getIndex(char c) {
        return (int) c - 'a';
    }
}

class TrieNode {
    private int ALPHABET_SIZE = 26;
    TrieNode[] children;
    boolean isEnd;

    public TrieNode() {
        children = new TrieNode[ALPHABET_SIZE];
        isEnd = false;
    }
}
