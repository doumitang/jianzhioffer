public class Solution51_2 {
    /**
     * 运行时间：14ms
     * 占用内存：8940k
     * @param A
     * @return
     */
    public int[] multiply(int[] A) {
        if (A == null || A.length == 0) return new int[0];
        int len = A.length;
        int[] ans = new int[len];
        ans[0] = 1;
        for (int i = 1; i < len; i++) {
            ans[i] = ans[i - 1] * A[i - 1];
        }
        int temp = 1;
        for (int i = len - 1; i >= 0; i--) {
            ans[i] *= temp;
            temp *= A[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution51_2 solution51_2 = new Solution51_2();
        int[] A = {1,2,3,4,5};
        solution51_2.multiply(A);
    }
}
