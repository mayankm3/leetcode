package solutions.medium.again;

import java.util.Stack;

public class SumofSubarrayRanges {

    // https://leetcode.com/problems/sum-of-subarray-ranges/
    // https://www.youtube.com/watch?v=gIrMptNPf5M
    // I derived by myself the pmee[] and nme[]
    // TC: O(10N) ~ O(N)
    // Can only be solved if you have done https://leetcode.com/problems/sum-of-subarray-minimums
    public long subArrayRanges(int[] nums) {
        int numsLength = nums.length;
        int[] psee = new int[numsLength];
        int[] nse = new int[numsLength];

        // previous smaller or equal element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numsLength; i++) {
            while (!stack.isEmpty() && nums[i] < nums[stack.peek()]){ // Why not <=? Well, sigh, first see video edge TC. Also imagine if TC has 1 1 6 7 3...
                stack.pop();
            }
            psee[i] = stack.isEmpty()? -1:stack.peek(); // assign index
            stack.push(i);
        }
        stack.clear();
        // next smaller element
        for (int i = numsLength-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] <= nums[stack.peek()]){
                stack.pop();
            }
            nse[i] = stack.isEmpty()? numsLength:stack.peek();  // storing index of next smaller element
            stack.push(i);  // storing indexes in stack
        }

        stack.clear();

        int[] pmee = new int[numsLength];
        int[] nme = new int[numsLength];
        // previous max or equal element
        for (int i = 0; i < numsLength; i++) {
            while (!stack.isEmpty() && nums[i] > nums[stack.peek()]){
                stack.pop();
            }
            pmee[i] = stack.isEmpty()? -1:stack.peek();
            stack.push(i);
        }
        stack.clear();
        // next max element
        for (int i = numsLength-1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[i] >= nums[stack.peek()]){
                stack.pop();
            }
            nme[i] = stack.isEmpty()?numsLength:stack.peek();
            stack.push(i);
        }

        /* optimization
        long answer = 0;
        for (int i = 0; i < numsLength; i++) {
            long leftLesser  = i - psee[i];
            long rightLesser = nse[i] - i;
            long leftGreater  = i - pmee[i];
            long rightGreater = nme[i] - i;
            answer += ((leftLesser*rightLesser)-(leftGreater*rightGreater)) * nums[i];
        }
        */

        long smaller = 0;
        for (int i = 0; i < numsLength; i++) {
            int leftCount  = i - psee[i];
            int rightCount = nse[i] - i;
            long minInNumOfSubArrays = (long) leftCount  * rightCount * nums[i];
            smaller += minInNumOfSubArrays;
        }

        long larger = 0;
        for (int i = 0; i < numsLength; i++) {
            int leftCount  = i - pmee[i];
            int rightCount = nme[i] - i;
            long maxInNumOfSubArrays = (long) leftCount  * rightCount * nums[i];
            larger += maxInNumOfSubArrays;
        }

        return larger-smaller;
    }
}
