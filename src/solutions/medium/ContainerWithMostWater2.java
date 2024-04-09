package solutions.medium;

public class ContainerWithMostWater2 {

    // https://leetcode.com/problems/container-with-most-water
    // https://leetcode.com/problems/container-with-most-water/solutions/1915172/java-c-easiest-explanations/
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
        System.out.println(maxArea(new int[]{0,0}));
        System.out.println(maxArea(new int[]{1,2,4,3}));
        System.out.println(maxArea(new int[]{6,4,3,1,4,6,99,62,1,2,6}));
        System.out.println(maxArea(new int[]{1,1000,1000,6,2,5,4,8,3,7}));
    }

    public static int maxArea(int[] height) {
        int left = 0, right = height.length-1, area = 0, currentArea;

        while (left<right){
            int currLeftHeight = height[left], currRightHeight = height[right];
            int currMinHeight = Math.min(currLeftHeight, currRightHeight);
            currentArea = currMinHeight*(right-left);

            area = Math.max(area, currentArea);

            if (currLeftHeight<=currRightHeight){
                left++;
            }
            else {
                right--;
            }
        }

        return area;
    }
}
