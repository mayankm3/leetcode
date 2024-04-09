package solutions.medium.again;

import java.util.Arrays;

public class SetMatrixZeroes1 {

    // https://leetcode.com/problems/set-matrix-zeroes/solutions/26008/my-ac-java-o-1-solution-easy-to-read/
    public static void main(String[] args) {
        int[][] myNumbers1 = { {1,1,1}, {1,0,1},{1,1,1}};
        setZeroes(myNumbers1);
        Arrays.stream(myNumbers1).forEach(arr-> Arrays.stream(arr).forEach(System.out::print));
        System.out.println("Hi");
        int[][] myNumbers2 = { {0,1,2,0}, {3,4,5,2},{1,3,1,5}};
        setZeroes(myNumbers2);
        Arrays.stream(myNumbers2).forEach(arr-> Arrays.stream(arr).forEach(System.out::print));
    }

    public static void setZeroes(int[][] matrix) {
        int rows = matrix.length, columns = matrix[0].length;;
        boolean firstRow = false, firstColumn = false;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if(matrix[i][j]==0){
                    if(i == 0) firstRow = true; // becomes true only if any element in first row is zero
                    if(j == 0) firstColumn = true;   // becomes true only if any element in first column is zero
                    matrix[i][0] = 0;   // setting row's first cell = 0
                    matrix[0][j] = 0;   // setting column's first cell = 0
                }
            }
        }

        for (int i = 1; i < rows; i++) {
            for (int j = 1; j < columns; j++) {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
        }

        if(firstRow) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrix[0][j] = 0;
            }
        }
        if(firstColumn) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}
