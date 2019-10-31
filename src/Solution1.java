public class Solution1 {
    public boolean Find(int target, int [][] array) {
        int m = array.length;
        if (m == 0) return false;
        int n = array[0].length;
        int i = m - 1, j = 0;
        while (i >= 0 && j < n) {
            if (array[i][j] == target) return true;
            else if (array[i][j] > target) i--;
            else j++;
        }
        return false;
    }
}
