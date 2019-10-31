import java.util.ArrayList;

public class Solution19 {
    /**
     * offer书第29题，比书上的思路简洁
     * 用四个变量标记矩阵边界，递归分解
     * @param matrix
     * @return
     */
    public ArrayList<Integer> printMatrix(int [][] matrix) {
        ArrayList<Integer> ans = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) return ans;
        int n = matrix[0].length;
        int top = 0, bottom = m - 1, left = 0, right = n - 1;
        while (true) {
            for (int j = left; j <= right; j++) {
                ans.add(matrix[top][j]);
            }
            top++;
            if (top > bottom) break;
            for (int i = top; i <= bottom; i++) {
                ans.add(matrix[i][right]);
            }
            right--;
            if (left > right) break;
            for (int j = right; j >= left; j--) {
                ans.add(matrix[bottom][j]);
            }
            bottom--;
            if (top > bottom) break;
            for (int i = bottom; i >= top; i--) {
                ans.add(matrix[i][left]);
            }
            left++;
            if (left > right) break;
        }
        return ans;
    }
}
