package solutions.medium.again;

import java.util.HashSet;

public class SudokuSolver {

    // https://leetcode.com/problems/sudoku-solver/description/
    // https://www.youtube.com/watch?v=FWAIf_EVUKE
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                if (board[row][col] == '.'){
                    for (char c = '1'; c <= '9'; c++) {
                        if (isValid(board, row, col, c)){
                            board[row][col] = c;
                            if (solve(board)) {
                                return true;
                            }
                            else {
                                board[row][col] = '.';
                            }
                        }
                    }

                    return false;   // if recursion call returns a false
                }
            }
        }

        return true;
    }

    private boolean isValid(char[][] board, int row, int col, char c){
        int blockOfRow = 3*(row/3), blockOfCol= 3*(col/3);
        for (int i = 0; i < 9; i++) {
            if (board[row][i] == c) return false;
            if (board[i][col] == c) return false;
            if (board[blockOfRow + i/3][blockOfCol + i%3] == c){
                return false;
            }
        }
        return true;
    }
}
