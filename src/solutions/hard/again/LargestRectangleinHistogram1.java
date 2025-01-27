package solutions.hard.again;

import java.util.Stack;

public class LargestRectangleinHistogram1 {

    // https://leetcode.com/problems/largest-rectangle-in-histogram
    // This solution was derived from https://leetcode.com/problems/sum-of-subarray-minimums/description/
    // I was able to solve 90% of this
    // TC: O(5N)
    public int largestRectangleArea(int[] heights) {
        int heightsLength = heights.length;
        int[] psee = new int[heightsLength];
        int[] nsee = new int[heightsLength];

        // previous smaller or equal element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < heightsLength; i++) {
            while (!stack.isEmpty() && heights[i] < heights[stack.peek()]){ // Why not <=? Well, sigh, first see video edge TC. Also imagine if TC has 1 1 6 7 3...
                stack.pop();
            }
            psee[i] = stack.isEmpty()? -1:stack.peek(); // assign index
            stack.push(i);
        }

        stack.clear();

        // next smaller element
        for (int i = heightsLength-1; i >= 0; i--) {
            while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]){
                stack.pop();
            }
            nsee[i] = stack.isEmpty()? heightsLength:stack.peek();  // storing index of next smaller element
            stack.push(i);  // storing indexes in stack
        }

        int maxArea = 0;
        for (int i = 0; i < heightsLength; i++) {
            int area = (nsee[i]-psee[i] -1) * heights[i];   // Missed only this
            maxArea = Math.max(maxArea, area);
        }

        return maxArea;
    }
}
