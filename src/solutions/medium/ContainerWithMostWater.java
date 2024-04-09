package solutions.medium;

public class ContainerWithMostWater {

    // https://leetcode.com/problems/container-with-most-water
    // It took me only Hint 2, couple of TC and 1hr55min.
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{0,0}));
        System.out.println(maxArea(new int[]{1,2,4,3}));
        System.out.println(maxArea(new int[]{6,4,3,1,4,6,99,62,1,2,6}));
        System.out.println(maxArea(new int[]{1,1000,1000,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int leftPointerAt = 0, numOfHeights = height.length, distanceBetween = numOfHeights;

        int firstMinHeight = Math.min(height[0], height[numOfHeights-1]);
        int area = firstMinHeight*(--distanceBetween);

        for (int i = 0, rightPointerAt=numOfHeights-1; i < numOfHeights; i++) {
            if (height[leftPointerAt]<=height[rightPointerAt]){
                leftPointerAt++;
                if (leftPointerAt==numOfHeights) break;
            }
            else {
                rightPointerAt--;
            }

            int currMinHeight = Math.min(height[leftPointerAt], height[rightPointerAt]);

            distanceBetween--;
            area = Math.max(area, currMinHeight*distanceBetween);
        }

        return area;
    }
}
