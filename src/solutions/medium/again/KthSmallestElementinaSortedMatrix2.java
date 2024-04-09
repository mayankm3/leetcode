package solutions.medium.again;

import java.util.Arrays;

public class KthSmallestElementinaSortedMatrix2 {

    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    // https://www.youtube.com/watch?v=dpsp1hP6P-U
    // https://www.youtube.com/watch?v=b4mkk8Fk8fs
    //TC: O(n*log (max - min)), n is number of iteration of binarysearch in countLessOrEqual().
    // 'max' and 'min' are the maximum and minimum values in the matrix.
    //SC: O(1)
    public static void main(String[] args) {
        int[][] myNumbers = { {1,5,9}, {10,11,13},{12,13,15}};
        System.out.println(kthSmallest(myNumbers, 8));

    }

    public static int kthSmallest(int[][] matrix, int k) {
        int matrixLength = matrix.length;
        int min = matrix[0][0], max = matrix[matrixLength-1][matrixLength-1];

        while (min!=max){
            int mid = min + (max-min)/2;
            int totalNumOfEle = countLessOrEqual(matrix, mid);
            if(totalNumOfEle<k){
                min = mid+1;
            }else {
                max = mid;
            }
        }

        return min;
    }

    private static int countLessOrEqual(int[][] matrix, int mid){
        int count = 0;
        int matrixLength = matrix.length;
        int row = 0;
        int column = matrixLength-1;

        while (row<matrixLength && column>=0){
            if(matrix[row][column]<=mid){
                count += column+1;
                row++;
            }else {
                column--;
            }
        }

        return count;
    }
}
