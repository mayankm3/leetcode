package solutions.easy;

public class SingleNumber {
    // Solved this problem in under 5 minutes since I had already solved the Missing number problem


    public static void main(String[] args) {
        int[] arr1 = {2,2,1};
        System.out.println(singleNumber(arr1));
        int[] arr2 = {4,1,2,1,2};
        System.out.println(singleNumber(arr2));
        int[] arr3 = {1};
        System.out.println(singleNumber(arr3));
    }

    public static int singleNumber(int[] nums){
        int lastManStanding = 0;
        for (int i = 0; i < nums.length; i++) {
            lastManStanding = lastManStanding^nums[i];
        }

        return lastManStanding;
    }
}
