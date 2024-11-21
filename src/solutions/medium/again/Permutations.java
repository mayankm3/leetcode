package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // https://leetcode.com/problems/permutations
    // https://www.youtube.com/watch?v=f2ic2Rsc9pU
    // TC: O(n*n!)
    public List<List<Integer>> permute(int[] nums) {
        List <List<Integer>> ans = new ArrayList<>();
        recursivelyPermute(ans, nums, 0);
        return ans;
    }

    private void recursivelyPermute(List<List<Integer>> ans, int[] nums, int index) {
        int numsLength = nums.length;
        if(index==numsLength){
            List<Integer> each = new ArrayList<>(numsLength);
            for (int i:nums) {
                each.add(i);
            }
            ans.add(each);
            return;
        }

        for (int i = index; i < numsLength; i++) {
            swap(i, index, nums);
            recursivelyPermute(ans, nums, index+1);
            swap(i, index, nums);   // backtrack
        }
    }

    private void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
