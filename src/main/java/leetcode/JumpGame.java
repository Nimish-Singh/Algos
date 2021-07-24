package leetcode;

// https://leetcode.com/problems/jump-game/
public class JumpGame {
    public boolean canJump(int[] nums) {
        int maxReachable = 0;

        for (int index = 0; index < nums.length; index++) {
            if (index > maxReachable)
                return false;
            maxReachable = Math.max(maxReachable, index + nums[index]);
        }
        return true;
    }
}
