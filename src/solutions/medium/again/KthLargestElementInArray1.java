package solutions.medium.again;

import java.util.PriorityQueue;

public class KthLargestElementInArray1 {

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 1, 5, 6, 4};
        int nums11 = findKthLargest(nums1, 2);
        System.out.println(nums11);

        int[] nums2 = {3,2,3,1,2,4,5,5,6};
        int nums22 = findKthLargest(nums2, 4);
        System.out.println(nums22);
    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<Integer>();   // The head of this queue is the least element
        for (int i = 0; i < nums.length; i++) {
            pQueue.add(nums[i]);
            if (pQueue.size() > k){
                pQueue.remove();    // works almost like poll method
            }
        }

        return pQueue.peek();   // This method returns the head of the queue.
    }
}
