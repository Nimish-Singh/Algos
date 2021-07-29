package backtracking;

// https://leetcode.com/problems/word-search/
public class WordSearch {
    public boolean exist(char[][] board, String word) {
        for (int row = 0; row < board.length; row++) {
            for (int column = 0; column < board[0].length; column++) {
                if (board[row][column] == word.charAt(0) && checkAdjacentCells(word, board, row, column, 0))
                    return true;
            }
        }
        return false;
    }

    private boolean checkAdjacentCells(String word, char[][] board, int rowIndex, int columnIndex, int wordIndex) {
        if (wordIndex == word.length())
            return true;

        if (rowIndex < 0 || rowIndex >= board.length || columnIndex < 0 || columnIndex >= board[0].length || board[rowIndex][columnIndex] == '#' || board[rowIndex][columnIndex] != word.charAt(wordIndex))
            return false;

        char letterBeingMasked = board[rowIndex][columnIndex];
        board[rowIndex][columnIndex] = '#';

        if (checkAdjacentCells(word, board, rowIndex + 1, columnIndex, wordIndex + 1) ||
                checkAdjacentCells(word, board, rowIndex, columnIndex + 1, wordIndex + 1) ||
                checkAdjacentCells(word, board, rowIndex - 1, columnIndex, wordIndex + 1) ||
                checkAdjacentCells(word, board, rowIndex, columnIndex - 1, wordIndex + 1))
            return true;

        board[rowIndex][columnIndex] = letterBeingMasked;
        return false;
    }
}
