package solutions.medium.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CombinationSumII {

    // https://leetcode.com/problems/combination-sum-ii/
    // https://www.youtube.com/watch?v=G1fRTGRxXU8
    // TC: k*2^n
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(candidates);    // since we need sorted combinations
        findCombination(0, candidates, target, result, new ArrayList<Integer>());
        return result;
    }

    private void findCombination(int index, int[] candidates, int target, List<List<Integer>> result,
                                 ArrayList<Integer> myList) {
        if (target == 0){
            result.add(new ArrayList<>(myList));
            return;
        }

        for (int i = index; i < candidates.length; i++) {
            int element = candidates[i];

            if (i>index && element==candidates[i-1]) continue;
            if (element>target) break;

            myList.add(element);
            findCombination(i+1, candidates, target-element, result, myList);
            myList.remove(myList.size()-1);
        }
    }
}
