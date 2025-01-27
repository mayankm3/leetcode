package solutions.medium.again;

import java.util.Stack;

public class SumofSubarrayMinimums {

    // https://leetcode.com/problems/sum-of-subarray-minimums/description/
    // https://www.youtube.com/watch?v=v0e8p9JCgRc
    // TC: O(5N)
    public int sumSubarrayMins(int[] arr) {
        int arrLength = arr.length;
        int[] psee = new int[arrLength];
        int[] nse = new int[arrLength];

        // previous smaller or equal element
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < arrLength; i++) {
            while (!stack.isEmpty() && arr[i] < arr[stack.peek()]){ // Why not <=? Well, sigh, first see video edge TC. Also imagine if TC has 1 1 6 7 3...
                stack.pop();
            }
            psee[i] = stack.isEmpty()? -1:stack.peek(); // assign index
            stack.push(i);
        }

        stack.clear();

        // next smaller element
        for (int i = arrLength-1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[i] <= arr[stack.peek()]){
                stack.pop();
            }
            nse[i] = stack.isEmpty()? arrLength:stack.peek();  // storing index of next smaller element
            stack.push(i);  // storing indexes in stack
        }

        long answer = 0;
        final long MOD = (long)1e9 + 7;
        for (int i = 0; i < arrLength; i++) {
            int leftCount  = i - psee[i];
            int rightCount = nse[i] - i;
            long minInNumOfSubArrays = (long) leftCount  * rightCount * arr[i];
            answer  = (answer + minInNumOfSubArrays) % MOD;
        }

        return (int) answer; // if MOD not done before then we can also do return (int) (answer % MOD);
    }

}
