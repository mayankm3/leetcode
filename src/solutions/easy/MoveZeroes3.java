package solutions.easy;

public class MoveZeroes3 {

    // https://leetcode.com/problems/move-zeroes/
    // https://youtu.be/wvcQg43_V8U?&t=2024
    // two pointer approach
    // try yourself once
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

        for (int i = 0, j=0; i <nLength; i++) {
            if (nums[i]!=0){
                int temp = nums[j];
                nums[j] = nums[i];
                nums[i] = temp;
                j++;
            }
        }

    }

}
