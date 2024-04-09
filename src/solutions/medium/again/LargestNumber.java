package solutions.medium.again;

import java.util.Arrays;
import java.util.Comparator;

public class LargestNumber {


    // https://leetcode.com/problems/largest-number/description
    // https://leetcode.com/problems/largest-number/solutions/53158/my-java-solution-to-share/
    public static void main(String[] args) {
//        largestNumber(new int[]{3, 30, 34, 5, 9});
        largestNumber(new int[]{0,0});
    }
    public static String largestNumber(int[] nums) {
        int numsLenth = nums.length;
        String[] stArr = new String[numsLenth];
        for (int i = 0; i < numsLenth; i++) {
            stArr[i] = String.valueOf(nums[i]);
        }

        Comparator<String> comparator = new Comparator<String>() {
            @Override
            public int compare(String a, String b) {
                String ab = a+b;
                String ba = b+a;
                return ba.compareTo(ab);    // descending order
//                return ab.compareTo(ba);  // ascending order
            }
        };

        Arrays.sort(stArr, comparator);

        if (stArr[0].equals("0")) return "0";    // to handle {0,0}

        StringBuilder result = new StringBuilder(numsLenth);
        for (String st:stArr) {
            result.append(st);
        }

        return result.toString();
    }
}
