package solutions.easy.again;

import java.util.HashSet;

public class MissingNumber1 {

    // https://leetcode.com/problems/missing-number/
    // If input is 0,1 then n=2 which mean array should have 0,1,2.
    public static void main(String[] args) {
        int num1 = missingNumber(new int[]{3,0,1});
        int num2 = missingNumber(new int[]{0,1});
        int num3 = missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    public static int missingNumber(int[] nums) {
        int numsLength = nums.length;
        
        HashSet<Integer> numsIntegerHashSet = new HashSet<>(numsLength);
        HashSet<Integer> integerHashSet = new HashSet<>(numsLength+1);
        integerHashSet.add(0);
        
        for (int i = 0; i < numsLength; i++) {
            numsIntegerHashSet.add(nums[i]);
            integerHashSet.add(i+1);
        }

        integerHashSet.removeAll(numsIntegerHashSet);

        return integerHashSet.iterator().next();
    }
}
