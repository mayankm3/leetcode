package solutions.medium.again;

import java.util.HashSet;

public class ValidSudoku {

    // https://leetcode.com/problems/valid-sudoku/description
    // https://leetcode.com/problems/valid-sudoku/solutions/15472/short-simple-java-using-strings/
    public boolean isValidSudoku(char[][] board) {
        HashSet<String> set = new HashSet<>(81);

        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                char charEle = board[row][col];

                if (charEle != '.'){
                    String ele = "(" + charEle + ")";

                    boolean presentInRow = !set.add(row+ele);   // If this set already contains the element, returns false.
                    boolean presentInCol = !set.add(ele+col);
                    boolean presentInBlock = !set.add(row/3 +ele+ col/3);
                    if (presentInRow || presentInCol || presentInBlock){
                        return false;
                    }
                }
            }
        }

        return true;
    }

}
