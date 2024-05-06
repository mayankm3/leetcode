package solutions.medium;

public class FactorialTrailingZeroes {

    public static void main(String[] args) {
        FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
        System.out.println(ftz.trailingZeroes(0));
        System.out.println(ftz.trailingZeroes(5));
        System.out.println(ftz.trailingZeroes(3));
    }

    // https://leetcode.com/problems/factorial-trailing-zeroes
    // https://www.purplemath.com/modules/factzero.htm
    // TC: O(log5(n))
    public int trailingZeroes(int n) {
        int countOfZeroes = 0;

        while (n>0){
            n /= 5;
            countOfZeroes += n;
        }

        return countOfZeroes;
    }
}
