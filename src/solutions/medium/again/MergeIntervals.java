package solutions.medium.again;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {

    // https://leetcode.com/problems/merge-intervals
    // Time complexity: O(nlogn) for sorting + O(n) = O(nlogn)
    public static void main(String[] args) {
        int[][] myNumbers = { {1,3}, {2,6},{8,10},{15,18}};
        System.out.println(Arrays.deepToString(merge(myNumbers)));
    }

    public static int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (first1, first2)-> first1[0]-first2[0]);

        List<int[]> result = new ArrayList<>();

        int[] prevInterval = intervals[0];
        result.add(prevInterval);

        for (int[] interval:intervals) {
            int upperBoundCurr = prevInterval[1];
            int nextLowerBound = interval[0];
            if(nextLowerBound<=upperBoundCurr){
                prevInterval[1] = Math.max(upperBoundCurr, interval[1]);
            }
            else {
                prevInterval = interval;
                result.add(prevInterval);
            }
        }

        // https://stackoverflow.com/questions/47135950/how-can-i-convert-a-listint-to-a-2d-array
        return result.toArray(new int[result.size()][]);
    }
}
