package solutions.medium;

public class FindPeakElement3 {

    // https://leetcode.com/problems/find-peak-element
    // https://leetcode.com/problems/find-peak-element/solutions/1290642/intuition-behind-conditions-complete-explanation-diagram-binary-search/
    public static void main(String[] args) {
        int[] arr0 = {1,3,2,1};
        System.out.println(findPeakElement(arr0));

        int[] arr1 = {1,2,3,1};
        System.out.println(findPeakElement(arr1));

        int[] arr2 = {1,2,1,3,5,6,4};
        System.out.println(findPeakElement(arr2));

        int[] arr3 = {-2147483648,-2147483647};
        System.out.println(findPeakElement(arr3));
    }

    public static int findPeakElement(int[] nums) {
        int numsLength = nums.length;
        if (numsLength==1) return 0;

        // Base cases: The array could be strictly increasing or strictly decreasing
        if (nums[0]>nums[1]) return 0;
        if (nums[numsLength-1]>nums[numsLength-2]) return numsLength-1;

        int start = 1, end = numsLength-2;
        while (start<=end){ // = is very important
            int mid = start + (end-start)/2;
            if(nums[mid-1]<nums[mid] && nums[mid]>nums[mid+1]) return mid;
            else if(nums[mid-1]>nums[mid]){
                end = mid-1;    // search space left side
            }
            else if (nums[mid]<nums[mid+1]){
                start = mid+1;  // search space right side
            }
        }

        return 0;   // dummy return statement
    }
}
