package solutions.medium.again;

public class JumpGameI3 {

    // https://leetcode.com/problems/jump-game/description
    // https://leetcode.com/problems/jump-game/solutions/4534808/super-simple-intuitive-8-line-python-solution-beats-99-92-of-users/

    // Easiest to understand
    // TC: O(n), we traverse the loop only once
    // SC O(1), not taking any extra space
    public boolean canJump(int[] nums) {
        int gas = 0;

        for (int num : nums) {
           if(gas<0) {
               return false;
           }
           else if (num>gas){
               gas = num;
           }
           gas--;
        }

        return true;
    }
}
