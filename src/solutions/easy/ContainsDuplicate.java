package solutions.easy;

import java.util.Arrays;

public class ContainsDuplicate {

    public static void main(String[] args) {
//        boolean result1 = containsDuplicate(new int[]{1,1,1,3,3,4,3,2,4,2});
//        boolean result2 = containsDuplicate(new int[]{1, 2, 3, 3, 5, 6});
//        boolean result3 = containsDuplicate(new int[]{1, 2, 3, 4});
        boolean result4 = containsDuplicate(new int[]{2,14,18,22,22});
        System.out.println(result4);
    }

    public static boolean containsDuplicate(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1]==nums[i]){
                return true;
            }
        }

        return false;
    }
}
