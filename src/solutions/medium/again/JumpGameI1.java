package solutions.medium.again;

public class JumpGameI1 {

    // https://leetcode.com/problems/jump-game/description
    // https://www.youtube.com/watch?v=Gtugy3mRV-A

    // Better revise solution of class JumpGameI2 since we will build off it in JumpGameII
    // TC: O(n), we traverse the loop only once
    // SC O(1), not taking any extra space
    public boolean canJump(int[] nums) {
        int checkPointIndex = nums.length-1, indexOfSecondLastEle = nums.length-2;

        for (int index = indexOfSecondLastEle; index >= 0; index--) {
            int valAtIndex = nums[index];
            if (index+valAtIndex >= checkPointIndex) {
                checkPointIndex = index;
            }
        }

        return checkPointIndex==0;
    }
}
