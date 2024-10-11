package solutions.medium.again;

public class KokoEatingBananas {

    public static void main(String[] args) {
        System.out.println(10/3);
        System.out.println(3/6);
        System.out.println(Math.ceil(3.0/6.0));
    }

    // https://leetcode.com/problems/powx-n/description/
    public int minEatingSpeed(int[] piles, int h) {
        int left = 1, right = 0;

        for (int pile:piles) {
            if (pile > right) right = pile;
        }

        while (left < right){
            int mid = left + (right-left)/2;

            if (timeAtKSpeed(piles, mid) <= h){
                right = mid;
            }
            else {
                left = mid+1;
            }
        }

        return left;
    }

    private int timeAtKSpeed(int[] piles, int k){
        int hours = 0;
        for (int pile:piles){
            // hours += (int) Math.ceil((double) pile /k);
            // or
            //https://stackoverflow.com/questions/48313359/division-in-java-to-get-next-upper-value/
            hours += (pile + k - 1)/k;
        }

        return hours;
    }
}
