package solutions.medium.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubsetsII {

    // https://leetcode.com/problems/subsets-ii/
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        findCombination(0, nums, result, new ArrayList<Integer>());
        return result;
    }

    private void findCombination(int index, int[] nums, List<List<Integer>> result,
                                 ArrayList<Integer> myList) {
        result.add(new ArrayList<>(myList));

        for (int i = index; i < nums.length; i++) {
            int element = nums[i];
            if (i>index && element==nums[i-1]) continue;

            myList.add(element);
            findCombination(i+1, nums, result, myList);
            myList.remove(myList.size()-1);
        }
    }
}
