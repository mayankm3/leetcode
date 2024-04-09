package solutions.easy.again;

import java.util.ArrayList;
import java.util.HashMap;

public class IntersectionofTwoArraysII {

    // The question is basically about frequencies, don't get fooled!
    // Next time see and try the Arrays.sort approach in LC Solutions.
    // https://leetcode.com/problems/intersection-of-two-arrays-ii
    // This solution is O(N + M) time complexity, O(N) for iterate one of the array to create a hashmap and O(M) to
    // iterate the other array. O(N) space to store such hashmap.
    public static void main(String[] args) {
//        int[] myArr = intersect(new int[]{1,2,2,1}, new int[]{2,2});
        int[] myArr = intersect(new int[]{4,9,5}, new int[]{9,4,9,8,4});
        System.out.println(myArr);
    }

    public static int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        for (int i = 0; i < nums1.length; i++) {
            int myEle = nums1[i];
            int frequency = hashMap.getOrDefault(myEle,0);
            hashMap.put(myEle, frequency+1);
        }

        for (int i = 0; i < nums2.length; i++) {
            int myEle = nums2[i];
            Integer myFreq = hashMap.get(myEle);
            if(hashMap.get(myEle)!=null && myFreq>0){
                arrayList.add(myEle);
                hashMap.put(myEle, myFreq-1);
            }
        }

        int[] result = new int[arrayList.size()];
        for (int i = 0; i < result.length; i++) {
            result[i] = arrayList.get(i);
        }

        return result;
    }
}
