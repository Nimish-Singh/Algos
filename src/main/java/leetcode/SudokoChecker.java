package leetcode;

import java.util.HashSet;
import java.util.Set;

// https://leetcode.com/problems/valid-sudoku/
public class SudokoChecker {
    public boolean isValidSudoku(char[][] board) {
        Set<String> nums = new HashSet<>();

        for (int row = 0; row < 9; row++) {
            for (int column = 0; column < 9; column++) {
                if (board[row][column] == '.') {
                    continue;
                }

                char cellNum = board[row][column];
                String rowNum = "row" + row + cellNum;
                String columnNum = "column" + column + cellNum;
                String squareNum = "square" + row / 3 + column / 3 + cellNum;

                if (nums.contains(rowNum) || nums.contains(columnNum) || nums.contains(squareNum))
                    return false;
                nums.add(rowNum);
                nums.add(columnNum);
                nums.add(squareNum);
            }
        }
        return true;
    }
}
