package solutions.medium.again;

public class MaxConsecutiveOnesIII {

    public int longestOnes(int[] nums, int k) {
        int left = 0, right = 0, numZeroes = 0, maxLength = 0;

        while (right < nums.length){
            if (nums[right] == 0){
                numZeroes++;
            }

            if (numZeroes > k){
                if (nums[left] == 0) numZeroes--;
                left++;
            }

            if (numZeroes <= k){
                maxLength = Math.max(maxLength, right-left+1);
            }

            right++;
        }

        return maxLength;
    }

}
