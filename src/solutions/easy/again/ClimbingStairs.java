package solutions.easy.again;

public class ClimbingStairs {
    // Time complexity: O(2^n) - since size of recursion tree will be 2^n
    // Space Complexity: O(n) - space required for the recursive function call stack.
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        if(n == 2) return 2;
        else return climbStairs(n-1) + climbStairs(n-2);

    }
}
