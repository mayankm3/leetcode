package solutions.medium;

public class Searcha2DMatrixII2 {

    // https://leetcode.com/problems/search-a-2d-matrix-ii
    // https://leetcode.com/problems/search-a-2d-matrix-ii/solutions/66140/my-concise-o-m-n-java-solution/
    // We can rule out one row or one column each time, so the time complexity is O(m+n).
    public static void main(String[] args) {
        int[][] arr0 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(arr0, 5));
        System.out.println(searchMatrix(arr0, 17));
        System.out.println(searchMatrix(arr0, 20));

        int[][] arr1 = {{-1},{-1}};
        System.out.println(searchMatrix(arr1, -2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int row = 0;
        int column = matrix[0].length-1;

        while (column>=0 && row<= matrix.length-1){
            if(target==matrix[row][column]) return true;
            else if(target<matrix[row][column]) column--;
            else if (target>matrix[row][column]) row++;
        }

        return false;
    }
}
