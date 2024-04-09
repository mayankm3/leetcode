package solutions.medium;

public class FindPeakElement1 {

    // https://leetcode.com/problems/find-peak-element
    // My own solution
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
        if (numsLength==2) return nums[0]>nums[1]?0:1;


        int currentBiggest = 0, maxElement = 0;

        for (int i = 0; i < numsLength; i+=2) {
            if(nums[i]>nums[i+1]){
                if(nums[i]>maxElement){
                    maxElement = nums[i];
                    currentBiggest = i;
                }
            }
            else {
                if(nums[i+1]>maxElement){
                    maxElement = nums[i+1];
                    currentBiggest = i+1;
                }
            }
            if(i+2==numsLength-1){
                currentBiggest = maxElement>nums[numsLength-1]?currentBiggest:numsLength-1;
                break;
            }
        }

        return currentBiggest;
    }
}
