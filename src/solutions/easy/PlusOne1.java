package solutions.easy;

import java.util.Arrays;

public class PlusOne1 {

    public static void main(String[] args) {
        int[] a = {9,9,3,9};
        int[] aa = plusOne(a);
        Arrays.stream(aa).forEach(System.out::print);

    }

    public static int[] plusOne(int[] digits) {

        for (int i = digits.length-1; i >= 0 ; i--) {
            if (digits[i]==9 && i == 0){
                int[] digitsMod = new int[digits.length+1];
                digitsMod[0] = 1;
                return digitsMod;
            }
            else {
                digits[i] += 1;

                if (digits[i] < 10) return digits;
                digits[i] = 0;

            }
        }

        return digits;
    }
}
