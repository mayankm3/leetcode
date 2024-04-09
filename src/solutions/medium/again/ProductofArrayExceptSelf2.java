package solutions.medium.again;

import java.util.Arrays;

public class ProductofArrayExceptSelf2 {

    // https://leetcode.com/problems/product-of-array-except-self/solutions/65622/simple-java-solution-in-o-n-without-extra-space/
    public static void main(String[] args) {
        int[] arr0 = {2,3,4,5};
        System.out.println(Arrays.toString(productExceptSelf(arr0))); // [24,12,8,6]
        int[] arr1 = {1,2,3,4};
        System.out.println(Arrays.toString(productExceptSelf(arr1))); // [24,12,8,6]
        int[] arr2 = {-1,1,0,-3,3};
        System.out.println(Arrays.toString(productExceptSelf(arr2)));    // [0,0,9,0,0]
    }

    public static int[] productExceptSelf(int[] nums) {
        int numsLength = nums.length;
        int[] answer = new int[numsLength];

        int left = 1;
        for (int i = 0; i < numsLength; i++) {
            if(i>0){
                left = left*nums[i-1];
            }
            answer[i] = left;
        }

        int right = 1;
        for (int i = numsLength-1; i >= 0; i--) {
            if(i<numsLength-1){
                right = right*nums[i+1];
            }
            answer[i] = answer[i]*right;
        }

        return answer;
    }
}
