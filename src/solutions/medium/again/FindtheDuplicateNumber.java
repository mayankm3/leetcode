package solutions.medium.again;

public class FindtheDuplicateNumber {

    // https://leetcode.com/problems/find-the-duplicate-number
    // Floyd's tortoise and hare algorithm
    // Time Complexity: O(n)
    // Space Complexity: O(1)
    // https://www.youtube.com/watch?v=32Ll35mhWg0
    // https://www.youtube.com/watch?v=wjYnzkAhcNk
    // https://www.youtube.com/watch?v=_n5MR8IxR6c
    // https://www.youtube.com/watch?v=95ZfuoSAUPI  (best proof)
    public static void main(String[] args) {
        int[] nums1 = {1,3,4,2,2};
        int nums11 = findDuplicate(nums1);
        System.out.println(nums11);

        int[] nums2 = {3,1,3,4,2};
        int nums22 = findDuplicate(nums2);
        System.out.println(nums22);
    }

    public static int findDuplicate(int[] nums) {
        int slow = 0, fast = 0;

        do{
            slow = nums[slow];    // moving one step at a time
            fast = nums[nums[fast]];      // moving two steps at a time
        }
        while (slow!=fast);

        fast = 0;   // moving the fast pointer back to starting

        while (slow!=fast){
            slow = nums[slow];  // moving one step at a time
            fast = nums[fast];  // moving one step at a time
        }

        return fast;
    }
}
