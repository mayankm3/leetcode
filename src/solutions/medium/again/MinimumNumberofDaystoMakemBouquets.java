package solutions.medium.again;

public class MinimumNumberofDaystoMakemBouquets {

    // Although I figured out the solution but still placed in again as I missed a few operators.
    // https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/description/
    // TC: O(NlogD); N is the number of flowers and D is the highest value in the array bloomDay
    // The search space is from 1 to D and for each of the chosen values of mid in the binary search we will iterate
    // over the N flowers. Therefore the time complexity is equal to O(NlogD).
    // SC: O(1); No extra space is required apart from a few variables
    // https://leetcode.com/problems/minimum-number-of-days-to-make-m-bouquets/solutions/686529/java-binary-search-with-detailed-explanation-runtime-o-nlog-maxdays-100/
    public int minDays(int[] bloomDay, int m, int k) {
        if(m > bloomDay.length/k) return -1;

        int low = Integer.MAX_VALUE, high = Integer.MIN_VALUE;

        for (int day:bloomDay){
            if (day < low) low = day;
            if (day > high) high = day;
        }

        while (low<=high){
            int mid = low + (high-low)/2;

            int bouquets = bloomed(bloomDay, k, mid);
            if (bouquets < m){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return low;
    }

    private int bloomed(int[] bloomDay, int k, int mid) {
        int bouquets = 0;
        int flowers = 0;

        for (int day:bloomDay){
            if (day <= mid) flowers++;
            else flowers = 0;

            if (flowers == k) {
                bouquets++;
                flowers = 0;
            }
        }

        return bouquets;
    }
}
