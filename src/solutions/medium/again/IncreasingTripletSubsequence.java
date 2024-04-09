package solutions.medium.again;

public class IncreasingTripletSubsequence {

    // https://leetcode.com/problems/increasing-triplet-subsequence/
    // https://www.youtube.com/watch?v=yEFlGWOVH8g
    public boolean increasingTriplet(int[] nums) {
        int smallest = Integer.MAX_VALUE, middle = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num <= smallest) {
                smallest = num;
            } else if (num <= middle) {
                middle = num;
            } else {
                return true;    // return true as soon as you find the biggest number
            }
        }

        return false;
    }
}
