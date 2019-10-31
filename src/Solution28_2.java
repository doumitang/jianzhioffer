public class Solution28_2 {
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        int ans = array[0], count = 1;
        for (int i = 1; i < array.length; i++) {
            if (array[i] == ans) count++;
            else {
                count--;
                if (count == 0) {
                    ans = array[i];
                    count = 1;
                }
            }
        }
        count = 0;
        for (int val:array) {
            if (val == ans) count++;
        }
        return count > array.length / 2 ? ans : 0;
    }
}
