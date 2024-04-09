package solutions.easy;

import java.util.Arrays;

public class PlusOne2 {

    public static void main(String[] args) {
        int[] a = {9,9,9,9};
        int[] aa = plusOne(a);
        Arrays.stream(aa).forEach(System.out::print);

    }

    public static int[] plusOne(int[] digits) {
        int dlen = digits.length;;

        for (int i = dlen-1; i >= 0 ; i--) {
            if (digits[i] <9){
                digits[i]++;
                return digits;

            }
            digits[i] = 0;
        }

        int[] digitsMod = new int[dlen+1];
        digitsMod[0] = 1;
        return digitsMod;
    }
}
