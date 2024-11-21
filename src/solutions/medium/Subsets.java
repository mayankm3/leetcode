package solutions.medium;

import java.util.ArrayList;
import java.util.List;

public class Subsets {

    // https://leetcode.com/problems/subsets/description/
    // Based on lectures in striver's recursion playlist, I was able to solve this
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0, nums, result, new ArrayList<Integer>());
        return result;
    }

    private void findCombination(int index, int[] nums, List<List<Integer>> result,
                                 ArrayList<Integer> myList) {
        if (index == nums.length) {
            result.add(new ArrayList<>(myList));
            return;
        }

        int element = nums[index];
        myList.add(element);
        findCombination(index+1, nums, result, myList);
        myList.remove(myList.size()-1);
        findCombination(index+1, nums, result, myList);
    }


}
