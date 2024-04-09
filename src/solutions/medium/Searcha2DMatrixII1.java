package solutions.medium;

public class Searcha2DMatrixII1 {

    public static void main(String[] args) {
        int[][] arr0 = {{1,4,7,11,15},{2,5,8,12,19},{3,6,9,16,22},{10,13,14,17,24},{18,21,23,26,30}};
        System.out.println(searchMatrix(arr0, 5));
        System.out.println(searchMatrix(arr0, 17));
        System.out.println(searchMatrix(arr0, 20));

        int[][] arr1 = {{-1},{-1}};
        System.out.println(searchMatrix(arr1, -2));
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;

        int start=0, end=columns-1;
        int atOrBeforeColumnNo=0;

        while (start<=end){
            int mid = start+(end-start)/2;
            atOrBeforeColumnNo = mid;
            int avgElement = matrix[0][mid];
            if(avgElement==target) return true;
            else if (target<avgElement) {
                end = mid-1;
            }
            else {
                start = mid+1;
            }
        }

        for (int i = atOrBeforeColumnNo; i >=0; i--) {
            int startR=1, endR=rows-1;
            while (startR<=endR){
                int mid = startR+(endR-startR)/2;
                int avgElement = matrix[mid][i];
                if(avgElement==target) return true;
                else if (target<avgElement) {
                    endR = mid-1;
                }
                else {
                    startR = mid+1;
                }
            }
        }

        return false;
    }
}
