public class Solution46_3 {
    /**
     * offer书第62题：圆圈中最后剩下的数字 P302
     * 运行时间：14ms
     * 占用内存：9300k
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
