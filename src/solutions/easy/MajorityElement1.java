package solutions.easy;

import java.util.HashMap;

public class MajorityElement1 {

    public static void main(String[] args) {
        int[] arr1 = {3,2,3};
        System.out.println(majorityElement(arr1));
        int[] arr2 = {2,2,1,1,1,2,2};
        System.out.println(majorityElement(arr2));
    }

    public static int majorityElement(int[] nums) {
        int majorityElement = 0;
        HashMap<Integer, Integer> frequencyHM = new HashMap<>();

        for (int element : nums) {
            if (!frequencyHM.containsKey(element)) {
                frequencyHM.put(element, 1);
            } else {
                int val = frequencyHM.get(element);
                frequencyHM.put(element, val+1);
            }
        }

        int currHighestFreq = 0;
        for (int fHMElement: frequencyHM.keySet()) {
            int frequency = frequencyHM.get(fHMElement);
            if(frequency>currHighestFreq) {
                majorityElement = fHMElement;
                currHighestFreq = frequency;
            }
        }

        return majorityElement;
    }

}
