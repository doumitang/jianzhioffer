public class Solution51 {
    /**
     * 左dp + 右dp（可以对空间复杂度进行优化）
     * 运行时间：14ms
     * 占用内存：9296k
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int len = A.length;
        int[] ans = new int[len];
        int[] dpLeft = new int[len];
        int[] dpRight = new int[len];
        dpLeft[0] = A[0];
        dpRight[len - 1] = A[len - 1];
        for (int i = 1, j = len - 2; i < len && j >=0; i++, j--) {
            dpLeft[i] = dpLeft[i - 1] * A[i];
            dpRight[j] = dpRight[j + 1] * A[j];
        }
        for (int i = 0; i < len; i++) {
            int left = 1, right = 1;
            if (i - 1 >= 0) left = dpLeft[i - 1];
            if (i + 1 < len) right = dpRight[i + 1];
            ans[i] = left * right;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution51 solution51 = new Solution51();
        int[] A = {1,2,3,4,5};
        solution51.multiply(A);
    }
}
