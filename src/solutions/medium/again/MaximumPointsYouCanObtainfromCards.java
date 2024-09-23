package solutions.medium.again;

public class MaximumPointsYouCanObtainfromCards {

    // https://leetcode.com/problems/maximum-points-you-can-obtain-from-cards/solutions/597825/simple-clean-intuitive-explanation-with-visualization/
    // https://www.youtube.com/watch?v=pBWCOCS636U
    public int maxScore(int[] cardPoints, int k) {
        int lSum = 0, rSum = 0;
        int maxPoints = 0;

        for (int i = 0; i < k; i++) {
            lSum = lSum + cardPoints[i];
        }
        maxPoints = lSum;
        int rIndex = cardPoints.length - 1;

        for (int i = k-1; i >= 0 ; i--) {
            lSum = lSum - cardPoints[i];
            rSum = rSum + cardPoints[rIndex];
            maxPoints = Math.max(maxPoints, lSum+rSum);
            rIndex--;
        }

        return maxPoints;
    }

}
