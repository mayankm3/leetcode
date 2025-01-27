package solutions.hard.again;

import java.util.Stack;

public class LargestRectangleinHistogram2 {

    // https://leetcode.com/problems/largest-rectangle-in-histogram
    // https://www.youtube.com/watch?v=Bzat9vgD0fs&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=13
    // This solution seems to be better
    // TC: O(2N)
    // SC: O(N)
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
