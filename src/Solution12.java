public class Solution12 {
    public double Power(double base, int exponent) {
        boolean isNegative = exponent < 0;
        if (isNegative) exponent = -exponent;
        double[] dp = new double[exponent + 1];
        dp[0] = 1;
        for (int i = 1; i < exponent + 1; i++) {
            double temp = dp[i / 2] * dp[i / 2];
            if (i % 2 == 0) dp[exponent] = temp;
            else dp[i] = temp * base;
        }
        return isNegative ? 1 / dp[exponent] : dp[exponent];
    }

    public static void main(String[] args) {
        Solution12 solution12 = new Solution12();
        solution12.Power(2, 3);
    }
}
