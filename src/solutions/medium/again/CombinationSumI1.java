package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI1 {

    // Line 27 to 34 is what I could think of based off striver's video
    // https://leetcode.com/problems/combination-sum/description/
    // https://www.youtube.com/watch?v=OyZFFqQtu98
    // TC: (2^t)*k
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        findCombination(0, candidates, target, result, new ArrayList<Integer>());
        return result;
    }

    private void findCombination(int index, int[] candidates, int target, List<List<Integer>> result,
                                                List<Integer> myList){
        if (target==0){
            result.add(new ArrayList<>(myList));   // not constant, it is linear time
            return;
        } else if (target<0 || index == candidates.length) {
            return;
        }

        int pick = candidates[index];
        target -= pick;
        myList.add(pick);
        findCombination(index, candidates, target, result, myList);

        myList.remove(myList.size()-1);
        target += pick;
        findCombination(index+1, candidates, target, result, myList);
    }
}
