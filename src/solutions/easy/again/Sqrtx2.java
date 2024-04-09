package solutions.easy.again;

public class Sqrtx2 {
    // https://www.youtube.com/watch?v=Jzcag2SOgYk

    // https://leetcode.com/problems/sqrtx/solutions/25047/a-binary-search-solution/
    // See second comment
    public static void main(String[] args) {
        System.out.println(mySqrt(17));
    }

    public static int mySqrt(int x) {

        // Base cases
        if(x == 0 || x == 1) return x;

        int left = 1;
        int right = x;

        while ( left <= right){
            int mid = left + (right - left) / 2;

            if (mid == x/mid) return mid;   // taking care of integer overflow
            else if (mid > x/mid) {
                right = mid-1;
            }
            else if(mid < x/mid) {
                left = mid+1;
            }
        }

        return right;

    }
}
