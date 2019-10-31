public class Solution9 {
    public int JumpFloorII(int target) {
        int[] dp = new int[target + 1];
        dp[1] = 1;
        for (int i = 2; i < target + 1; i++) {
            dp[i] = dp[i - 1] * 2;
        }
        return dp[target];
    }
}
