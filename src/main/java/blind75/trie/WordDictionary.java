package blind75.trie;

// https://leetcode.com/problems/design-add-and-search-words-data-structure/
public class WordDictionary {
    private final Node root;

    public WordDictionary() {
        root = new Node();
    }

    public void addWord(String word) {
        Node temp = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (temp.alphabets[translateToArrayIndex(c)] == null)
                temp.alphabets[translateToArrayIndex(c)] = new Node();
            temp = temp.alphabets[translateToArrayIndex(c)];
        }
        temp.isTerminal = true;
    }

    public boolean search(String word) {
        return searchForNode(word, root);
    }

    private boolean searchForNode(String word, Node node) {
        for (int index = 0; index < word.length(); index++) {
            char c = word.toLowerCase().charAt(index);
            if (c != '.') {
                Node alphabet = node.alphabets[translateToArrayIndex(c)];
                if (alphabet == null)
                    return false;
                node = alphabet;
            } else {
                for (Node alphabet : node.alphabets) {
                    boolean isPresent = alphabet != null && searchForNode(word.substring(index + 1), alphabet);
                    if (isPresent)
                        return true;
                }
                return false;
            }
        }
        return node.isTerminal;
    }

    private int translateToArrayIndex(char c) {
        return c - 'a';
    }
}
