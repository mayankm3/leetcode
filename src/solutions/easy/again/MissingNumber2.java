package solutions.easy.again;

import java.util.HashSet;

public class MissingNumber2 {

    // https://www.youtube.com/watch?v=406y4hq66UM until 04:12
    // Output of System.out.println(8^6^5^6^5^8^10);??? Answer is 10.

    //Solution MissingNumber2, MissingNumber3, and MissingNumber4 are progressive simplifications

    // any number XOR with 0 will stay unchanged
    // a number XOR itself will become 0
    // So if every number from 1...n XOR with itself except the missing number, the result will be the missing number.
    public static void main(String[] args) {
        int num1 = missingNumber(new int[]{3,0,1});
        int num2 = missingNumber(new int[]{0,1});
        int num3 = missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    public static int missingNumber(int[] nums) {
        int xorArr = 0;
        for (int num : nums) {
            xorArr ^= num;
        }

        int xorAllArr = 0;
        for (int i = 0; i <= nums.length; i++) {
            xorAllArr ^= i;
        }

        return xorArr^xorAllArr;
    }
}
