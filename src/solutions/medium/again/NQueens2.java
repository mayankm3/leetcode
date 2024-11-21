package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class NQueens2 {

    // https://www.youtube.com/watch?v=i05Ju7AftcM
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }

        boolean[] rowView = new boolean[n];
        boolean[] lowerDiagonal =  new boolean[2*n - 1];
        boolean[] upperDiagonal =  new boolean[2*n - 1];
        noTwoQueensAttack(0, n, result, board, rowView, lowerDiagonal, upperDiagonal);
        return result;
    }

    private void noTwoQueensAttack(int column, int n, List<List<String>> result, char[][] board, boolean[] rowView,
                                   boolean[] lowerDiagonal, boolean[] upperDiagonal) {
        if (column==n){
            result.add(construct(board));
            return;
        }

        for (int row = 0; row < n; row++) {
            if (rowView[row] == false && lowerDiagonal[row+column] == false && upperDiagonal[n-1+column-row] == false){
                board[row][column] = 'Q';
                rowView[row] = true;
                lowerDiagonal[row+column] = true;
                upperDiagonal[n-1+column-row] = true;

                noTwoQueensAttack(column+1, n, result, board, rowView, lowerDiagonal, upperDiagonal);

                board[row][column] = '.';
                rowView[row] = false;
                lowerDiagonal[row+column] = false;
                upperDiagonal[n-1+column-row] = false;
            }
        }
    }

    private List<String> construct(char[][] board){
        List<String> answer = new ArrayList<String>();
        for (char[] chars : board) {
            String element = new String(chars);
            answer.add(element);
        }
        return answer;
    }
}
