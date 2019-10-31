import java.util.ArrayList;
import java.util.List;

public class Solution46_2 {
    /**
     * 不用visit数组，用ArrayList模拟删除
     * 运行时间：22ms
     * 占用内存：9684k
     *
     * LinkedList
     * 运行时间：40ms
     * 占用内存：9680k
     * @param n
     * @param m
     * @return
     */
    public int LastRemaining_Solution(int n, int m) {
        if (n < 1 || m < 1) return -1;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + m - 1) % list.size();
            list.remove(index);
            if (index == list.size()) index = 0;
        }
        return list.get(0);
    }
}
