package solutions.medium.again;

import java.util.Arrays;

public class KthSmallestElementinaSortedMatrix1 {

    // https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/
    // Brute force approach
    public static void main(String[] args) {
        int[][] myNumbers = { {1,5,9}, {10,11,13},{12,13,15}};
        System.out.println(kthSmallest(myNumbers, 8));

    }

    public static int kthSmallest(int[][] matrix, int k) {
        int matrixLength = matrix.length;
        int[] intArray = new int[matrixLength*matrixLength];

        int count = 0;
        for (int i = 0; i < matrixLength; i++) {
            for (int j = 0; j < matrixLength; j++) {
                intArray[count] = matrix[i][j];
                count++;
            }
        }

        Arrays.sort(intArray);

        return intArray[k-1];
    }
}
