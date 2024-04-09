package solutions.easy.again;

public class MissingNumber3 {

    // https://leetcode.com/problems/missing-number/discuss/69791/4-Line-Simple-Java-Bit-Manipulate-Solution-with-Explaination
    // In comments of solution by mo10
    // See simplification in comments from reply to shank1499 by mattihito
    public static void main(String[] args) {
        int num1 = missingNumber(new int[]{3,0,1});
        int num2 = missingNumber(new int[]{0,1});
        int num3 = missingNumber(new int[]{9,6,4,2,3,5,7,0,1});
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num3);
    }

    public static int missingNumber(int[] nums) {
        int xorAllArr = 0;
        for (int i = 0; i <= nums.length; i++) {
            xorAllArr ^= i;

            if (i<nums.length){
                xorAllArr ^= nums[i];
            }
        }

        return xorAllArr;
    }
}
