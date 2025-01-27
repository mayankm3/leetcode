package solutions.hard.again;

import java.util.Stack;

public class MaximalRectangle {

    // https://leetcode.com/problems/maximal-rectangle/description/
    // https://www.youtube.com/watch?v=ttVu6G7Ayik&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=14
    // My solution is based on below
    // https://leetcode.com/problems/maximal-rectangle/solutions/122456/easiest-solution-build-on-top-of-leetcod-a1ig/
    // TC: O(M*N) + O(M*2N) -> derive from LargestRectangleinHistogram
    // SC: O(N) + O(N)
    public int maximalRectangle(char[][] matrix) {
        int rows = matrix.length;
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == '0'){
                    heights[j] = 0;
                }else {
                    heights[j]++;
                }
            }

            // calculate max area for each row
            maxArea = Math.max(maxArea, largestRectangleArea(heights));
        }

        return maxArea;
    }

    public int largestRectangleArea(int[] heights) {
        int heightsLength = heights.length, maxArea = 0;
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < heightsLength; i++) {
            while (!stack.isEmpty() && heights[i]<heights[stack.peek()]){
                int indexCalcArea = stack.pop();
                int prevSmallerEleIndex = stack.isEmpty()? -1:stack.peek();
                int area = heights[indexCalcArea] * (i-prevSmallerEleIndex-1);   // height * width
                maxArea = Math.max(maxArea, area);
            }
            stack.push(i);
        }

        // for any remaining elements
        while (!stack.isEmpty()){
            int indexCalcArea = stack.pop();
            int prevSmallerEleIndex = stack.isEmpty()? -1:stack.peek();
            int area = heights[indexCalcArea] * (heightsLength-prevSmallerEleIndex-1);
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
