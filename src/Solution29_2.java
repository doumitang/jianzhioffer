import java.util.ArrayList;
import java.util.Arrays;

public class Solution29_2 {
    /**
     * 最大堆法，数组实现
     * @param input
     * @param k
     * @return
     */
    public ArrayList<Integer> GetLeastNumbers_Solution(int [] input, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        if (k < 1 || k > input.length) return ans;
        int[] maxHeap = new int[k];
        for (int i = 0; i < k; i++) {
            insert(maxHeap, input[i], i);
        }
//        System.out.println(Arrays.toString(maxHeap));
        for (int i = k; i < input.length; i++) {
            if (input[i] < maxHeap[0]) {
                maxHeap[0] = input[i];
                siftDown(maxHeap, 0, k);
            }
        }
        for (int i = 0; i < k; i++) {
            ans.add(maxHeap[i]);
        }
//        System.out.println(ans);
        return ans;
    }

    private void insert(int[] maxHeap, int val, int i) {
        maxHeap[i] = val;
        while (maxHeap[i] > maxHeap[(i - 1) / 2]) {
            swap(maxHeap, i, (i - 1) / 2);
            i = (i - 1) / 2;
        }
    }

    private void siftDown(int[] maxHeap, int i, int heapSize) {
        int child = i * 2 + 1;
        while (child < heapSize) {
            child = child + 1 < heapSize && maxHeap[child + 1] > maxHeap[child] ? child + 1 : child;
            if (maxHeap[i] >= maxHeap[child]) break;
            swap(maxHeap, i, child);
            i = child;
            child = child * 2 + 1;
        }
    }

    private void swap(int[] maxHeap, int p1, int p2) {
        int temp = maxHeap[p1];
        maxHeap[p1] = maxHeap[p2];
        maxHeap[p2] = temp;
    }

    public static void main(String[] args) {
        Solution29_2 solution29_2 = new Solution29_2();
        int[] array = {4,5,1,6,2,7,3,8};
        solution29_2.GetLeastNumbers_Solution(array, 4);
    }
}
