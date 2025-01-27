package solutions.easy.again;

import java.util.HashMap;
import java.util.Stack;

public class NextGreaterElementI {

    // https://leetcode.com/problems/next-greater-element-i/description/
    // GPT assisted solution
    // code comments by GPT
    // good test case: nums1[] = [137,59,92,122,52,131,79,236,94,171,141,86,169,199,248]
    // nums2 = [137,59,92,122,52,131,79,236,94,171,141,86,169,199,248]
    // TC: O(2N) https://www.youtube.com/watch?v=e7XQLtOQM3I
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int nums1Length = nums1.length;
        int nums2Length = nums2.length;
        int[] result = new int[nums1Length];
        // Stack to keep track of the next greater elements
        Stack<Integer> stack = new Stack<>();
        // Map to store the next greater element for each element in nums2
        HashMap<Integer, Integer> nextGreaterMap = new HashMap<>(nums2Length);

        // Iterate through nums2 in reverse order
        for (int j = nums2Length-1; j >=0 ; j--) {
            int eleFromNums2 = nums2[j];

            // Pop all elements from the stack that are less than or equal to the current num
            while (!stack.empty() && eleFromNums2 >= stack.peek()){
                stack.pop();
            }

            // If the stack is not empty, the top element is the next greater element
            if (!stack.empty()){
                nextGreaterMap.put(eleFromNums2, stack.peek());
            }else {
                nextGreaterMap.put(eleFromNums2, -1); // No greater element
            }

            // Push the current element onto the stack
            stack.add(eleFromNums2);
        }

        for (int i = 0; i < nums1Length; i++) {
            result[i] = nextGreaterMap.get(nums1[i]);
        }

        return result;
    }
}
