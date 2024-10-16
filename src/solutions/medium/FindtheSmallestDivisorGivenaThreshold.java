package solutions.medium;

public class FindtheSmallestDivisorGivenaThreshold {

    // This problem is same as Koko eating Bananas
    // https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/description/
    public int smallestDivisor(int[] nums, int threshold) {
        int low = 1, high = Integer.MIN_VALUE;
        int smallestDiv = 0;

        for (int num:nums){
            if (num>high) high = num;
        }

        while (low <= high){
            int mid = low + (high-low)/2;

            int sum = divideAndCeilAndSum(nums, mid);

            if (sum<=threshold) smallestDiv = mid;
//            if (smallestDiv<=threshold && sum>threshold) return smallestDiv;

            if (sum > threshold){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return smallestDiv;
    }

    private int divideAndCeilAndSum(int[] nums, int mid){
        int sum = 0;
        for (int num:nums){
            sum += (num+mid-1)/mid;
        }

        return sum;
    }


}
