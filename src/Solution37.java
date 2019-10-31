import java.util.Arrays;

public class Solution37 {
    public int GetNumberOfK(int [] array , int k) {
        if (array == null || array.length == 0) return 0;
        int pos = find(array, k);
        if (pos < 0) return 0;
        int i = pos, j = pos;
        while (i >= 0 && array[i] == k) i--;
        while (j < array.length && array[j] == k) j++;
        return j - i - 1;
    }

    private int find(int[] array, int k) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (array[mid] == k) return mid;
            if (k < array[mid]) right = mid - 1;
            else left = mid + 1;
        }
        return -(left + 1); // left为第一个大于k的位置
    }

    public static void main(String[] args) {
        Solution37 solution37 = new Solution37();
        int[] array = {3,3,3,3,4,5};
        solution37.GetNumberOfK(array, 3);
    }
}
