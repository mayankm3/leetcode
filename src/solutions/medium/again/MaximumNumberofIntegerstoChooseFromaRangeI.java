package solutions.medium.again;

import java.util.HashSet;
import java.util.Set;

public class MaximumNumberofIntegerstoChooseFromaRangeI {

    // https://leetcode.com/problems/maximum-number-of-integers-to-choose-from-a-range-i/
    // // Asked to me in Freecharge
    public int maxCount(int[] banned, int n, int maxSum) {
        Set<Integer> setOfBanned = new HashSet<>(banned.length);
        int currentSum = 0, count = 0;

        for (int j : banned) {
            setOfBanned.add(j);
        }

        for(int i= 1; i<=n; i++){
            if(setOfBanned.contains(i)) continue;

            currentSum += i;

            if (currentSum > maxSum) break;
//            if (currentSum > maxSum) return 0;  // Made this one mistake in Freecharge interview :(
            count++;
        }

        return count;
    }

}
