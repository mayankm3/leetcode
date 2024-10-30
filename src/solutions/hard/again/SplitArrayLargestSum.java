package solutions.hard.again;

public class SplitArrayLargestSum {

    // l = 10, h = 32, m = 21
    // l = 10, h = 20, m = 15
    // l = 16, h = 20, m = 18
    // l = 16, h = 17, m = 16
    // l = 17, h = 17, m = 17
    // l = 18, h = 17

    // https://leetcode.com/problems/split-array-largest-sum/description/
    // This problem is same as https://leetcode.com/problems/capacity-to-ship-packages-within-d-days/description/
    // Also same as the problem for book allocation and painter's partition
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;

        for (int num:nums){
            if (num>low) low = num;
            high += num;
        }

        while (low<=high){
            int mid = low + (high-low)/2;

            boolean minimizedSum = calcNoOfWays(nums, k, mid);
            if (minimizedSum){
                high = mid - 1;
            }else {
                low = mid + 1;
            }
        }

        return low;
    }

    private boolean calcNoOfWays(int[] nums, int k, int mid) {
        int count = 1, sumOfNums = 0;

        for (int num:nums){
            if (num>mid || count>k) return false;

            if (num + sumOfNums > mid){
                sumOfNums = 0;
                count++;
            }

            sumOfNums += num;
        }

        return count<=k;
    }

}
