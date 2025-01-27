package solutions.hard.again;

public class TrappingRainWater {

    // https://leetcode.com/problems/trapping-rain-water/description/
    // too difficult
    // I did the easier solution in python, it seems to be more useful
    // https://www.youtube.com/watch?v=ZI2z5pq0TqA
    // https://leetcode.com/problems/trapping-rain-water/solutions/153992/java-on-time-and-o1-space-with-explanati-akt0/
    // https://leetcode.com/problems/trapping-rain-water/solutions/1374608/cjavapython-maxleft-maxright-so-far-with-8196/
    public int trap(int[] height) {
        int totalWater = 0;
        int left=0, right=height.length-1;
        int maxLeftHeight = 0, maxRightHeight = 0;

        while (left<right){
            int currLeftHeight = height[left];
            int currRightHeight = height[right];

            if (currLeftHeight <= currRightHeight){ // potential to store water towards right side
                if (currLeftHeight >= maxLeftHeight){
                    maxLeftHeight = currLeftHeight;
                }else {
                    totalWater += maxLeftHeight - currLeftHeight;
                }
                left++;
            }else {
                if (currRightHeight >= maxRightHeight){
                    maxRightHeight = currRightHeight;
                }
                else {
                    totalWater += maxRightHeight - currRightHeight;
                }
                right--;
            }
        }

        return totalWater ;
    }


}
