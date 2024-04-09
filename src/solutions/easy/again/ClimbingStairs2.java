package solutions.easy.again;

public class ClimbingStairs2 {
    // Time complexity: O(n)
    // Space Complexity: O(1)
    // dynamic programming
    // See discussion section's most upvoted comment for intuition
    public static void main(String[] args) {
        System.out.println(climbStairs(5));
    }

    public static int climbStairs(int n) {
        if(n <= 2) return n;

        int twoStepsBefore = 1;
        int oneStepBefore = 2;
        int totalWays = 0;

        // if n=3 then (3-2) + (3-1) = 1 + 2 ways = 3
        // if n=4 then (4-2) + (4-1) = (n=2 + n=3) ways = 5
        // if n=5 then (5-2) + (5-1) = (n=3 + n=4) ways = 8
        // if n=6 then (6-2) + (6-1) = (n=4 + n=5) ways = 13
        for (int i = 2; i < n; i++) {
            totalWays = twoStepsBefore + oneStepBefore;
            twoStepsBefore = oneStepBefore;
            oneStepBefore = totalWays;
        }

        return totalWays;
    }
}
