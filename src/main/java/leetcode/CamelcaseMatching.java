package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// https://leetcode.com/problems/camelcase-matching/
public class CamelcaseMatching {
    public List<Boolean> camelMatch(String[] queries, String pattern) {
        Trie trie = new Trie();
        trie.insert(pattern);

        return Arrays
                .stream(queries)
                .map(query -> trie.search(query))
                .collect(Collectors.toList());
    }

    class Trie {
        private TrieNode root;
        private List<Character> patternLetters;

        Trie() {
            root = new TrieNode();
            patternLetters = new ArrayList<>();
        }

        public void insert(String pattern) {
            TrieNode temp = root;
            for (char c : pattern.toCharArray()) {
                patternLetters.add(c);

                if (!temp.children.containsKey(c)) {
                    temp.children.put(c, new TrieNode());
                }

                temp = temp.children.get(c);
            }
        }

        public boolean search(String query) {
            TrieNode temp = root;
            List<Character> patternChars = new ArrayList<>(patternLetters);

            for (char c : query.toCharArray()) {
                if (temp.children.containsKey(c)) {
                    patternChars.remove(Character.valueOf(c));
                    temp = temp.children.get(c);
                    continue;
                }

                if (c <= 90) // is uppercase letter
                    return false;
            }

            return patternChars.isEmpty();
        }
    }

    class TrieNode {
        Map<Character, TrieNode> children;

        TrieNode() {
            children = new HashMap<>();
        }
    }
}
