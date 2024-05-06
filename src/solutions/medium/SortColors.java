package solutions.medium;

import java.util.Arrays;

public class SortColors {

    // https://leetcode.com/problems/sort-colors/solutions/3464652/beats-100-c-java-python-javascript-two-pointer-dutch-national-flag-algorithm/
    // https://www.youtube.com/watch?v=6sMssUHgaBs
    public void sortColors(int[] nums) {
        int start = 0, middle = 0, end = nums.length-1;

        while (middle<=end){
            if (nums[middle]==0){
                swap(nums, start, middle);
                start++;
                middle++;
            }
            else if (nums[middle]==1){
                middle++;
            }
            else {
                swap(nums, middle, end);
                end--;
            }
        }
    }

    private void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
