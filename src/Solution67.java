public class Solution67 {
    /**
     * 动态规划，时间O(n^2)，空间O(n)
     * 关键在于前面几个特殊值的处理
     *
     * 运行时间：15ms
     * 占用内存：9560k
     * @param target
     * @return
     */
    public int cutRope(int target) {
        // 先处理特殊值
        if (target <= 2) return 1;
        if (target == 3) return 2;
        int[] dp = new int[target + 1];
        dp[0] = 0; // 不允许不剪
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        for (int i = 4; i < target + 1; i++) {
            for (int j = 1; j <= i / 2; j++) {
                dp[i] = Math.max(dp[i], dp[j] * (i - j));
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Solution67 solution67 = new Solution67();
        solution67.cutRope(4);
    }
}
