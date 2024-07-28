package solutions.medium.again;

public class CountNumberofNiceSubarrays {

    // https://leetcode.com/problems/count-number-of-nice-subarrays/
    // Same as https://leetcode.com/problems/binary-subarrays-with-sum/
    public int numberOfSubarrays(int[] nums, int k) {
        return countLessThanOrEqualToK(nums, k) - countLessThanOrEqualToK(nums, k-1);
    }

    private int countLessThanOrEqualToK(int[] arr, int myK) {
        if (myK < 0) return 0;

        int left = 0, right = 0, sum = 0, niceSubarrays = 0;

        while (right < arr.length) {
            sum += arr[right]%2;

            while (sum > myK) {
                sum -= arr[left]%2;
                left++;
            }

            niceSubarrays += (right-left+1);

            right++;
        }

        return niceSubarrays;
    }
}
