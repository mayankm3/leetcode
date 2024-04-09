package solutions.medium.again;

import java.util.*;

public class TopKFrequentElements3 {

    // https://www.youtube.com/watch?v=YPTqKIgVk-k
    public static void main(String[] args) {
        int[] nums1 = {1,1,1,2,2,3};
        int[] nums11 = topKFrequent(nums1, 2);
        Arrays.stream(nums11).forEach(System.out::print);
        System.out.println();

        int[] nums2 = {1};
        int[] nums22 = topKFrequent(nums2, 1);
        Arrays.stream(nums22).forEach(System.out::print);
        System.out.println();
    }


    public static int[] topKFrequent(int[] nums, int k) {
        int numsLength = nums.length;

        if(nums == null || numsLength == 0) return new int[0];

        Map<Integer, Integer> map = new HashMap<>();
        for (int i:nums) {
            map.put(i, map.getOrDefault(i, 0)+1);
        }

        List<Integer>[] bucket = new List[numsLength+1];   // int[] arr; is an array. Its each element is a List of Integer.
        for (Integer key:map.keySet()) {
            Integer frequency = map.get(key);
            if(bucket[frequency] == null){
                bucket[frequency] = new ArrayList<>();
            }
            bucket[frequency].add(key);
        }

        int[] res = new int[k];
        for (int i = numsLength; i>0 ; i--) {
            if (!(bucket[i]==null)){
                for (int p = 0; p < bucket[i].size(); p++) {
                    res[--k] = bucket[i].get(p);
                }
            }

            if(k==0) break;
        }

        return res;
    }
}
