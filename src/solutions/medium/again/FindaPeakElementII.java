package solutions.medium.again;

public class FindaPeakElementII {

    // https://leetcode.com/problems/find-a-peak-element-ii/description/
    // https://www.youtube.com/watch?v=nGGp5XBzC4g
    // TC: n*O(logm)
    public int[] findPeakGrid(int[][] mat) {
        int rows = mat.length;
        int cols = mat[0].length;

        int low = 0, high = cols-1;

        while (low<=high){
            int mid = low + (high-low)/2;
            int rowIndex = findIndexOfMaxInRow(mat, rows, mid);
            int leftEle = mid-1 >= 0 ? mat[rowIndex][mid-1] :-1;
            int rightEle = mid+1 < cols ? mat[rowIndex][mid+1] :-1; // cannot use <=. If you do then there is no element at index, say 5+1=6!
            int ele = mat[rowIndex][mid];
            if (ele>leftEle && ele>rightEle){
                return new int[]{rowIndex, mid};
            }
            else if(leftEle>ele){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return new int[]{-1, -1};
    }

    private int findIndexOfMaxInRow(int[][] mat, int rows, int mid) {
        int maxEle = -1, index = -1;
        for (int i = 0; i < rows; i++) {
            int ele = mat[i][mid];
            if (ele > maxEle) {
                maxEle = ele;
                index = i;
            }
        }

        return index;
    }

}
