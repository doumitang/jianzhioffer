import java.util.HashMap;
import java.util.Map;

public class Solution28 {
    /**
     * 用map存次数，时间O(n)，但是空间也是O(n)
     * @param array
     * @return
     */
    public int MoreThanHalfNum_Solution(int [] array) {
        if (array == null || array.length == 0) return 0;
        if (array.length == 1) return array[0];
        Map<Integer, Integer> map = new HashMap<>();
        for (int val:array) {
            if (!map.containsKey(val)) map.put(val, 1);
            else {
                int count = map.get(val) + 1;
                if (count > array.length / 2) return val;
                map.put(val, count);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Solution28 solution28 = new Solution28();
        int[] array = {1,2,3,2,4,2,5,2,3};
        solution28.MoreThanHalfNum_Solution(array);
    }
}
