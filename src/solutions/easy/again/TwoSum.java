package solutions.easy.again;

import java.util.HashMap;

public class TwoSum {
    // Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

    public static void main(String[] args) {
        int[] nums = {-1,-2,-3,-4,-5};
        int target = -8;

        int[] answer = twoSum(nums, target);

        for (int i: answer) {
            System.out.println(i);
        }
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int y = target - nums[i];

            if(hashMap.containsKey(y)) {
                return new int[]{hashMap.get(y), i};
            }
            hashMap.put(nums[i], i);
        }

        return null;

    }


}
