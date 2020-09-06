public class Solution46_3 {
    /**
     * offer书第62题：圆圈中最后剩下的数字 P302
     * 运行时间：14ms
     * 占用内存：9300k
     *
     * f(n - 1, m) 的解就是 f(n, m) 的解，只不过要做一个变换，令 k = (m - 1) % n
     *
     * f(n, m)  --------->  f(n - 1, m)
     * k + 1    --------->  0
     * k + 2    --------->  1
     * k + 3    --------->  2
     * ...
     * n - 1
     * 0
     * ...
     * k - 2    --------->  n - 3
     * k - 1    --------->  n - 2
     *
     * 令 x = f(n - 1, m) 的话，x' = f(n, m) = (x + k + 1) % n
     * 所以 dp[i] = (dp[i - 1] + (m - 1) % i + 1) % i = (dp[i - 1] + m - 1 + 1) % i = (dp[i - 1] + m) % i
     * 其中 dp[1] = 0
     *
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int last = 0;
        for (int i = 2; i <= n; i++) {
            last = (last + m) % i;
        }
        return last;
    }
}
