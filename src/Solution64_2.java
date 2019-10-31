import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;

public class Solution64_2 {
    /**
     * offer书第59题
     * 把滑动窗口看成一个队列，只把有可能成为最大值的下标存进去，不可能的就移除
     *
     * 运行时间：16ms
     * 占用内存：9232k
     * @param num
     * @param size
     * @return
     */
    public ArrayList<Integer> maxInWindows(int [] num, int size) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (num == null || num.length == 0 || size < 1 || size > num.length) return ans;
        Deque<Integer> queue = new LinkedList<>(); // 保证队头是最大值
        for (int i = 0; i < size; i++) {
            while (!queue.isEmpty() && num[queue.getLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
        }
        ans.add(num[queue.getFirst()]);
        for (int i = size; i < num.length; i++) {
            if ((i - queue.getFirst()) >= size) queue.pollFirst();
            while (!queue.isEmpty() && num[queue.getLast()] < num[i]) {
                queue.pollLast();
            }
            queue.offerLast(i);
            ans.add(num[queue.getFirst()]);
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution64_2 solution64_2 = new Solution64_2();
        int[] num = {2,3,4,2,6,2,5,1};
        System.out.println(solution64_2.maxInWindows(num, 3));
    }
}
