package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class Permutations {

    // https://leetcode.com/problems/permutations
    // https://www.youtube.com/watch?v=f2ic2Rsc9pU
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List < List < Integer >> ls = permute(nums);
        for (List<Integer> l : ls) {
            for (int j = 0; j < l.size(); j++) {
                System.out.print(l.get(j) + " ");
            }
            System.out.println();
        }
    }

    public static List<List<Integer>> permute(int[] nums) {
        List <List<Integer>> ans = new ArrayList<>();
        recursivelyPermute(ans, nums, 0);
        return ans;
    }

    private static void recursivelyPermute(List<List<Integer>> ans, int[] nums, int index) {
        int numsLength = nums.length;
        if(index==numsLength){
            List<Integer> each = new ArrayList<>(numsLength);
            for (int i:nums) {
                each.add(i);
            }
            ans.add(each);
            return;
        }

        for (int i = index; i < nums.length; i++) {
            swap(i, index, nums);
            recursivelyPermute(ans, nums, index+1);
            swap(i, index, nums);   // backtrack
        }
    }

    private static void swap(int i, int j, int[] arr){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
