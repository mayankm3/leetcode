package solutions.medium.again;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class LongestConsecutiveSequence3 {

    // https://leetcode.com/problems/longest-consecutive-sequence/description/
    // https://www.youtube.com/watch?v=oO5uLE7EUlM&t=776s
    // Below comment by aiayumi in reply to princemaxx
    // Say input has 10mil items, with streaks of 10k in length throughout, so inner loop gets triggered
    // 10mil / 10k =1000 times, each running 10k items. Does that still sound like a O(n) solution?
    // What if 100mil items? TLDR; I still think O(mn) is a more accurate representation here.
    public static void main(String[] args) {
        int[] arr1 = {100,4,200,1,3,2};
        System.out.println(longestConsecutive(arr1));

        int[] arr2 = {0,3,7,2,5,8,4,6,0,1};
        System.out.println(longestConsecutive(arr2));

        int[] arr3 = {9,1,4,7,3,-1,0,5,8,-1,6};
        System.out.println(longestConsecutive(arr3));

        int[] arr4 = {-8,-4,9,9,4,6,1,-4,-1,6,8};
        System.out.println(longestConsecutive(arr4));
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length==0) return 0;

        Set<Integer> set = new HashSet<>();
        int maxConsequent = 1;

        for (int num : nums) {
            set.add(num);
        }

        for (Integer ele:set) {
            if(!set.contains(ele-1)){
                int x = ele;
                while (set.contains(++x)){
                }
                int count = x - ele;
                maxConsequent = Math.max(maxConsequent, count);
            }
        }

        return maxConsequent;
    }
}
