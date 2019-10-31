public class Solution66 {
    private boolean[] visited;
    private int count;

    /**
     * 回溯法
     *
     * 运行时间：16ms
     * 占用内存：9320k
     * @param threshold
     * @param rows
     * @param cols
     * @return
     */
    public int movingCount(int threshold, int rows, int cols) {
        if (rows < 0 || cols < 0) return 0;
        visited = new boolean[rows * cols];
        recursion(threshold, rows, cols, 0, 0);
        return count;
    }

    private void recursion(int threshold, int rows, int cols, int i, int j) {
        if (i < 0 || i >= rows || j < 0 || j >= cols) return;
        if (visited[cols * i + j] || getSum(i, j) > threshold) return;
        visited[cols * i + j] = true;
        count++;
        recursion(threshold, rows, cols, i - 1, j);
        recursion(threshold, rows, cols, i + 1, j);
        recursion(threshold, rows, cols, i, j - 1);
        recursion(threshold, rows, cols, i, j + 1);
    }

    private int getSum(int i, int j) {
        int sum = 0;
        while (i > 0) {
            sum += i % 10;
            i = i / 10;
        }
        while (j > 0) {
            sum += j % 10;
            j = j / 10;
        }
        return sum;
    }
}
