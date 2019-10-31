public class Solution30 {
    public int FindGreatestSumOfSubArray(int[] array) {
        int len = array.length, ans = Integer.MIN_VALUE;
        int[] dp = new int[len];
        dp[0] = array[0];
        for (int i = 1; i < len; i++) {
            dp[i] = Math.max(dp[i - 1] + array[i], array[i]);
            ans = Math.max(ans, dp[i]);
        }
        return ans;
    }
}
