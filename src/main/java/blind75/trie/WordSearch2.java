package blind75.trie;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://leetcode.com/problems/word-search-ii/
public class WordSearch2 {
    private Node root;

    public List<String> findWords(char[][] board, String[] words) {
        root = new Node();
        for (String word : words)
            addWord(word);

        Set<String> answer = new HashSet<>();
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (root.alphabets[board[row][column] - 'a'] != null)
                    search(board, row, column, root, "", answer, visited);
            }
        }

        return new ArrayList<>(answer);
    }

    private void search(char[][] board, int row, int column, Node node, String wordSoFar, Set<String> answer, boolean[][] visited) {
        if (row >= board.length || row < 0 || column >= board[0].length || column < 0 || visited[row][column])
            return;

        if (node.alphabets[board[row][column] - 'a'] == null) {
            return;
        }

        visited[row][column] = true;
        node = node.alphabets[board[row][column] - 'a'];
        if (node.isTerminal) {
            answer.add(wordSoFar + board[row][column]);
        }

        search(board, row - 1, column, node, wordSoFar + board[row][column], answer, visited);
        search(board, row + 1, column, node, wordSoFar + board[row][column], answer, visited);
        search(board, row, column - 1, node, wordSoFar + board[row][column], answer, visited);
        search(board, row, column + 1, node, wordSoFar + board[row][column], answer, visited);

        visited[row][column] = false;
    }

    private void addWord(String word) {
        Node temp = root;
        for (char c : word.toLowerCase().toCharArray()) {
            if (temp.alphabets[c - 'a'] == null)
                temp.alphabets[c - 'a'] = new Node();
            temp = temp.alphabets[c - 'a'];
        }
        temp.isTerminal = true;
    }
}
