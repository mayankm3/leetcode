package solutions.medium.again;

import java.util.Arrays;

public class SetMatrixZeroes2 {

    // https://leetcode.com/problems/set-matrix-zeroes/solutions/26014/any-shorter-o-1-space-solution/
    // https://youtu.be/M65xBewcqcI?t=340
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
        boolean makeFirstColumnZero = false;

        for (int i = 0; i < rows; i++) {
            if(matrix[i][0]==0) makeFirstColumnZero = true;
            for (int j = 1; j < columns; j++) { // so a matrix of m*(n-1)
                if(matrix[i][j]==0){
                    matrix[i][0] = 0;   // setting row's first cell = 0
                    matrix[0][j] = 0;   // setting column's first cell = 0
                }
            }
        }

        for (int i = rows-1; i >=0; i--) {
            for (int j = columns-1; j >= 1; j--) {
                if(matrix[i][0]==0 || matrix[0][j]==0){
                    matrix[i][j]=0;
                }
            }
            if(makeFirstColumnZero){
                matrix[i][0] = 0;
            }
        }
    }
}
