import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

public class Solution29 {
    /**
     * 最大堆法，PriorityQueue实现
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k < 1 || k > input.length) return ans;
        Queue<Integer> maxHeap = new PriorityQueue<>(k, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        for (int i = 0; i < k; i++) {
            maxHeap.offer(input[i]);
        }
//        System.out.println(maxHeap);
        for (int i = k; i < input.length; i++) {
            if (maxHeap.isEmpty()) maxHeap.offer(input[i]);
            else if (input[i] < maxHeap.peek()) {
                maxHeap.poll();
                maxHeap.offer(input[i]);
            }
        }
        while (!maxHeap.isEmpty()) {
            ans.add(maxHeap.poll());
        }
//        System.out.println(ans);
        return ans;
    }

    public static void main(String[] args) {
        Solution29_2 solution29_2 = new Solution29_2();
        int[] array = {4,5,1,6,2,7,3,8};
        solution29_2.GetLeastNumbers_Solution(array, 4);
    }
}
