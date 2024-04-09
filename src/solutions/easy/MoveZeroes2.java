package solutions.easy;

public class MoveZeroes2 {

    // https://leetcode.com/problems/move-zeroes/
    // A very unique & practical solution
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
        int nLength = nums.length, blockOfZeroes = 0;

        for (int i = 0; i <nLength; i++) {
            if (nums[i]==0){
                blockOfZeroes++;
            }
            else {
                int temp = nums[i];
                nums[i] = 0;
                nums[i-blockOfZeroes] = temp;
            }
        }
    }
}
