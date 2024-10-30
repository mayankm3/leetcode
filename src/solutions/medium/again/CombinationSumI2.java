package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class CombinationSumI2 {

    // https://leetcode.com/problems/combination-sum/description/
    // https://www.youtube.com/watch?v=OyZFFqQtu98
    // TC: (2^t)*k
    // https://leetcode.com/problems/combination-sum/solutions/1755084/detailed-time-and-space-complexity-analysis-c-java-backtracking/
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
        } else if (index == candidates.length) {
            return;
        }

        int element = candidates[index];
        if (element <= target){
            myList.add(element);
            findCombination(index, candidates, target-element, result, myList);
            myList.remove(myList.size()-1);
        }

        findCombination(index+1, candidates, target, result, myList);
    }
}
