package solutions.medium;

import java.util.Arrays;

public class MagneticForceBetweenTwoBalls {

    // https://www.youtube.com/watch?v=R_Mfw4ew-Vo similar problem in leetcode
    // https://leetcode.com/problems/magnetic-force-between-two-balls/
    // TC: O(NlogN) + N*O(log(high))
    // SC: O(1)
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = (position[position.length-1] - position[0])/m-1;

        while (low<=high){
            int mid = low + (high-low)/2;
            if (canWePlaceAll(position, m, mid)){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }

        return high;    // why return high? see after 20:00
    }

    private boolean canWePlaceAll(int[] positions, int balls, int minForce){
        int countOfBalls = 1, lastBallPos = positions[0];

        for (int i = 1; i < positions.length; i++) {
            int currentBallPos = positions[i];
            if(currentBallPos - lastBallPos >= minForce){
                countOfBalls++;
                lastBallPos = currentBallPos;
            }
            if (countOfBalls>=balls) return true;
        }

        return false;
    }
}
