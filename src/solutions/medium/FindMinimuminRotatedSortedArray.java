package solutions.medium;

public class FindMinimuminRotatedSortedArray {

    // https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/description/
    // a better answer
    int findMin(int[] nums) {

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;  // why not mid-1? Check TC [3,1,2]
            }
        }

        return nums[left];
    }

    // my answer
    //    public int findMin(int[] nums) {
//        int minimum = Integer.MAX_VALUE;
//        int low = 0, high = nums.length-1;
//
////        if (nums[low]<=nums[high]) return nums[low];
//
//        while (low <= high){
//            int mid = low + (high-low)/2;
//
//            if (nums[mid] <= minimum) minimum = nums[mid];
//
//            if (nums[mid]>nums[high]){
//                low = mid + 1;
//            }
//            else {
//                high = mid -1;
//            }
//        }
//
//        return minimum;
//    }
}
