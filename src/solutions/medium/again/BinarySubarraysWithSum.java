package solutions.medium.again;

public class BinarySubarraysWithSum {

    // https://leetcode.com/problems/binary-subarrays-with-sum/
    // https://www.youtube.com/watch?v=XnMdNUkX6VM
    // TC: O(2*2N)
    // SC: O(1)
    public int numSubarraysWithSum(int[] nums, int goal) {
        return countLessThanOrEqualToGoal(nums, goal) - countLessThanOrEqualToGoal(nums, goal-1);
    }

    // TC: O(2N)
    // SC: O(1)
    private int countLessThanOrEqualToGoal(int[] arr, int goal){
        if (goal < 0) return 0;

        int left = 0, right = 0, sum = 0, count = 0;

        while (right < arr.length){
            sum += arr[right];

            while (sum > goal){
                sum -= arr[left];
                left++;
            }

            count += (right-left+1);

            right++;
        }

        return count;
    }
}
