package solutions.hard.again;

import java.util.ArrayDeque;
import java.util.Deque;

public class SlidingWindowMaximum {

    // https://leetcode.com/problems/sliding-window-maximum
    // https://www.youtube.com/watch?v=NwBvene4Imo&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=18
    // https://leetcode.com/problems/sliding-window-maximum/solutions/871317/clear-thinking-process-with-picture-brut-hfkh/
    // TC: O(2N); TC: 100,99,98... 3,2,1,101 now you will removeLast() 100 times
    public int[] maxSlidingWindow(int[] nums, int k) {
        int numsLength = nums.length;
        Deque<Integer> deque = new ArrayDeque<>();  // stores indices; max element at front always
        int[] res = new int[numsLength-k+1];
        int index = 0;

        for (int i = 0; i < numsLength; i++) {
            while (!deque.isEmpty() && nums[i]>=nums[deque.peekLast()]){
                deque.removeLast();
            }
            deque.addLast(i);

            // if element is now outside the window then remove it from front of queue
            if (deque.peekFirst() == i-k){
                deque.removeFirst();
            }

            // start adding elements once i has become equal to k-1
            if (i>=k-1){    // or i+1>=k
                res[index++] = nums[deque.peekFirst()];
            }
        }

        return res;
    }
}
