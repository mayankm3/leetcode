package solutions.easy.again;

public class MissingNumber4 {

    public static void main(String[] args) {
        int num1 = missingNumber(new int[]{3,0,1});
        int num2 = missingNumber(new int[]{0,1});
        int num3 = missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    public static int missingNumber(int[] nums) {
        int xorAllArr = nums.length;
        for (int i = 0; i < nums.length; i++) {
            xorAllArr = xorAllArr^i^nums[i];    // Assume input example 3:
                                                // for loop will generate numbers from 0 to 8
                                                // int xorAllArr  = nums.length; will bring 9
                                                // Now we have numbers from 0 to 9.
                                                // for loop nums[i] will pull the numbers from the array.
        }

        return xorAllArr;
    }
}
