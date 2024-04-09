package solutions.easy;

public class MoveZeroes1 {

    // https://leetcode.com/problems/move-zeroes/
    // This is what I came up with, certainly has O(n) time complexity
    public static void main(String[] args) {
        int[] arr1 = {0,1,0,3,12};
        moveZeroes(arr1);
        int[] arr2 = {0};
        moveZeroes(arr2);
        int[] arr3 = {0,0,0,0,12};
        moveZeroes(arr3);
        int[] arr4 = {0,0,4,0};
        moveZeroes(arr4);
    }

    public static void moveZeroes(int[] nums) {
        int nLength = nums.length;

        for (int i = nLength-1; i >= 0; i--) {
            if (nums[i]==0){
                for (int j = i; j < nLength-1; j++) {
                    nums[j] = nums[j+1];
                    nums[j+1] = 0;
                }
            }
        }

//        for (int a: nums) {
//            System.out.print(a+",");
//        }
//        System.out.println("\nFinished\n");
    }
}
