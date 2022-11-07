package blind75.trie;

// https://leetcode.com/problems/implement-trie-prefix-tree/
public class Trie {
    private Node root;

    public Trie() {
        root = new Node();
    }

    public void insert(String word) {
        Node temp = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (temp.alphabets[translateToArrayIndex(c)] == null)
                temp.alphabets[translateToArrayIndex(c)] = new Node();
            temp = temp.alphabets[translateToArrayIndex(c)];
        }
        temp.isTerminal = true;
    }

    public boolean search(String word) {
        Node temp = root;
        for (char c : word.toLowerCase().toCharArray()) {
            Node alphabet = temp.alphabets[translateToArrayIndex(c)];
            if (alphabet == null)
                return false;
            temp = alphabet;
        }
        return temp.isTerminal;
    }

    public boolean startsWith(String prefix) {
        Node temp = root;
        for (char c : prefix.toLowerCase().toCharArray()) {
            Node alphabet = temp.alphabets[translateToArrayIndex(c)];
            if (alphabet == null)
                return false;
            temp = alphabet;
        }
        return true;
    }

    private int translateToArrayIndex(char c) {
        return c - 'a';
    }
}

class Node {
    private static int ALPHABET_SIZE = 26;

    boolean isTerminal;
    Node[] alphabets;

    public Node() {
        isTerminal = false;
        alphabets = new Node[ALPHABET_SIZE];
    }
}