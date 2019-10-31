import java.util.ArrayList;

public class Solution64 {
    /**
     * 先暴力求解试试，复杂度也就O(n * k)，k是滑动窗口长度
     *
     * 运行时间：17ms
     * 占用内存：9116k
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1) return ans;
        int len = num.length;
        for (int i = 0; i <= len - size; i++) {
            int temp = Integer.MIN_VALUE;
            for (int j = i; j < i + size; j++) {
                temp = Math.max(temp, num[j]);
            }
            ans.add(temp);
        }
        return ans;
    }
}
