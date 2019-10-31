import java.util.Arrays;

public class Solution65 {

    private boolean[] visited;

    /**
     * 回溯法
     *
     * 运行时间：17ms
     * 占用内存：9164k
     * @param matrix
     * @param rows
     * @param cols
     * @param str
     * @return
     */
    public boolean hasPath(char[] matrix, int rows, int cols, char[] str) {
        if (matrix == null || rows == 0 || cols == 0) return false;
        visited = new boolean[rows * cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (recursion(matrix, rows, cols, str, i, j, 0)) return true;
            }
        }
        return false;
    }

    private boolean recursion(char[] matrix, int rows, int cols, char[] str, int i, int j, int index) {
        if (index == str.length) return true;
        if (i < 0 || i >= rows || j < 0 || j >= cols) return false;
        int pos = cols * i + j;
        if (visited[pos] || matrix[pos] != str[index]) return false;
        visited[pos] = true;
        if (recursion(matrix, rows, cols, str, i - 1, j, index + 1)) return true;
        if (recursion(matrix, rows, cols, str, i + 1, j, index + 1)) return true;
        if (recursion(matrix, rows, cols, str, i, j - 1, index + 1)) return true;
        if (recursion(matrix, rows, cols, str, i, j + 1, index + 1)) return true;
        // 置位回退
        visited[pos] = false;
        return false;
    }

    public static void main(String[] args) {
        Solution65 solution65 = new Solution65();
        char[] matrix = {'A','B','C','E','S','F','C','S','A','D','E','E'};
        char[] str = {'A','B','C','C','E','D'};
        char[] matrix1 = {'A','A','A','A','A','A','A','A','A','A','A','A'};
        char[] str1 = {'A','A','A','A','A','A','A','A','A','A','A','A'};
        System.out.println(solution65.hasPath(matrix1, 3, 4, str1));
    }
}
