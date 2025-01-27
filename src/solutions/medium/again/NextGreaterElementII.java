package solutions.medium.again;

import java.util.Stack;

public class NextGreaterElementII {

    // https://leetcode.com/problems/next-greater-element-ii/description/
    // Based on below solution
    // https://leetcode.com/problems/next-greater-element-ii/solutions/98273/java-10-lines-and-c-12-lines-linear-time-22z8/comments/102633
    // below is also good
    // https://leetcode.com/problems/next-greater-element-ii/solutions/98270/javacpython-loop-twice-by-lee215-oayh/comments/335669
    // TC: O(4N); https://www.youtube.com/watch?v=7PrncD7v9YQ; consider the TC [5,4,3,2,1]
    public int[] nextGreaterElements(int[] nums) {
        int numsLength = nums.length;
        int[] result = new int[numsLength];
        Stack<Integer> stack = new Stack<>();

        for (int i = (2*numsLength)-1; i >= 0; i--) {
            int index = i % numsLength;
            int num = nums[index];

            while (!stack.isEmpty() && num >= stack.peek()){
                stack.pop();
            }
            if (i< numsLength){
                result[index] = stack.isEmpty()? -1:stack.peek();
            }

            stack.add(num);
        }

        return result;
    }

}
