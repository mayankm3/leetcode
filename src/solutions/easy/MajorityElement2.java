package solutions.easy;

import java.util.HashMap;

public class MajorityElement2 {

    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        System.out.println(majorityElement(arr1));
        int[] arr2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr2));
    }

    public static int majorityElement(int[] nums) {
        int n = nums.length/2;
        HashMap<Integer, Integer> frequencyHM = new HashMap<>();

        for (int element : nums) {
            frequencyHM.put(element, frequencyHM.getOrDefault(element, 0)+1);
        }

        for (int fHMElement: frequencyHM.keySet()) {
            int frequency = frequencyHM.get(fHMElement);
            if(frequency>n) {
                return fHMElement;
            }
        }

        return n;   // won't ever reach here :)
    }

}
