public class Solution46 {
    /**
     * 用visit数组标记是否出队
     * 运行时间：350ms
     * 占用内存：9268k
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        int[] visit = new int[n];
        int index = 0, count = 0, remain = n;
        while (count < m) {
            while (visit[index] == 1) index = (index + 1) % n;
            count++;
            if (count == m) {
                remain--;
                visit[index] = 1;
                count = 0;
            }
            index = (index + 1) % n;
            if (remain == 1) break;
        }
        while (visit[index] == 1) index = (index + 1) % n;
        return index;
    }

    public static void main(String[] args) {
        Solution46 solution46 = new Solution46();
        solution46.LastRemaining_Solution(5, 3);
    }
}
