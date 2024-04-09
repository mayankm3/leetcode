package solutions.medium.again;

public class JumpGameI2 {

    // https://leetcode.com/problems/jump-game/description
    // https://leetcode.com/problems/jump-game/solutions/20932/6-line-java-solution-in-o-n/

    // Easier to understand
    // TC: O(n), we traverse the loop only once
    // SC O(1), not taking any extra space
    public boolean canJump(int[] nums) {
        int reachability = 0;

        for (int index = 0; index < nums.length; index++) {
            int valAtIndex = nums[index];

            if (index>reachability) return false;

            reachability = Math.max(index+valAtIndex, reachability);
        }

        return true;
    }
}
