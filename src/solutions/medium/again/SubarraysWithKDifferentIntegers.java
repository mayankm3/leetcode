package solutions.medium.again;

import java.util.HashMap;

public class SubarraysWithKDifferentIntegers {

    // https://leetcode.com/problems/subarrays-with-k-different-integers/
    // TC: O(2N), assuming map works in constant time
    // SC: O(N)? It should be O(K)
    public int subarraysWithKDistinct(int[] nums, int k) {
        return helper(nums, k) - helper(nums, k-1);
    }

    private int helper(int[] myNums, int myk){
        if (myk <= 0) return 0;

        int left = 0, right = 0, count = 0, arrSize = myNums.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while (right < arrSize){
            int rightKey = myNums[right];
            hashMap.put(rightKey, hashMap.getOrDefault(rightKey, 0) + 1);

            while (hashMap.size() > myk){
                int leftKey = myNums[left];
                hashMap.put(leftKey, hashMap.get(leftKey) - 1);
                if (hashMap.get(leftKey) == 0) hashMap.remove(leftKey);
                left++;
            }

            count += (right-left+1);
            right++;
        }

        return count;
    }

}
