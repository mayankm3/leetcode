package solutions.medium.again;

public class KthMissingPositiveNumber {

    // https://leetcode.com/problems/kth-missing-positive-number/
    public int findKthPositive(int[] arr, int k) {
        int left = 0, right = arr.length-1;

        while (left<=right){
            int mid = (left+right)/2;

            int missingNums = arr[mid] - (mid+1);   // thanks to GPT

            if (missingNums < k){
                left = mid+1;
            }
            else {
                right = mid-1;
            }
        }

        return left+k;
    }
}
