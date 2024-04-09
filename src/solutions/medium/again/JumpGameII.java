package solutions.medium.again;

public class JumpGameII {

    // https://leetcode.com/problems/jump-game-ii
    // https://www.youtube.com/watch?v=9kyHYVxL4fw
    // As per https://leetcode.com/problems/jump-game-ii/solutions/18014/concise-o-n-one-loop-java-solution-based-on-greedy
    // this type of solution is an implicit BFS solution

    // TC: O(n), we traverse the array only once
    // SC O(1), not taking any extra space
    public int jump(int[] nums) {
        if(nums.length==1) return 0;

        int numsLength = nums.length, indexOfLastEle=nums.length-1;
        int reachability=0, jumps=0, lastJumpedIndex = 0;

        for (int index = 0; index < numsLength; index++) {
            int valAtIndex = nums[index];

            reachability = Math.max(reachability, index+valAtIndex);

            if (index==lastJumpedIndex) {
                lastJumpedIndex = reachability;
                jumps++;

                if (reachability >= indexOfLastEle) {
                    break;
                }
            }
        }

        return jumps;
    }
}
