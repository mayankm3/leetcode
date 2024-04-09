package solutions.easy.again;

public class Sqrtx {
    // https://www.youtube.com/watch?v=Jzcag2SOgYk
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

            if (mid*mid == x) return mid;
            else if (mid*mid > x) {
                right = mid-1;
            }
            else if(mid*mid < x) {
                left = mid+1;
            }
        }

        return right;

    }
}
