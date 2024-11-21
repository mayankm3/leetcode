package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    // I tied but this cannot be solved by https://leetcode.com/problems/permutations
    // Why? See results at bottom https://youtu.be/f2ic2Rsc9pU?t=598, not sorted!

    // https://www.youtube.com/watch?v=wT7gcXLYoao
    // TC: O(n^2)
    public String getPermutation(int n, int k) {
        List<Integer> numberList = new ArrayList<>(n);
        int fact = 1;
        for (int i = 1; i <n; i++) {
            fact = fact*i;
            numberList.add(i);
        }
        numberList.add(n);

        String ans = "";
        k = k - 1;
        while (true){
            ans = ans + numberList.remove(k/fact);

            int sizeOfList = numberList.size();
            if (sizeOfList == 0) break;

            k = k % fact;
            fact = fact/sizeOfList;
        }
        return ans;
    }




}
