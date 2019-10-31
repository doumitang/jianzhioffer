import java.util.ArrayList;
import java.util.List;

public class Solution63 {
    private List<Integer> array = new ArrayList<>();

    /**
     * 二分查找
     * 运行时间：19ms
     * 占用内存：9572k
     * @param num
     */
    public void Insert(Integer num) {
        int pos = binarySearch(array, num);
        array.add(pos, num);
    }

    public Double GetMedian() {
        int size = array.size();
        if (size == 0) return 0d;
        if (size % 2 == 1) return Double.valueOf(array.get(size / 2));
        return (array.get(size / 2) + array.get(size / 2 - 1)) / 2.0;
    }

    // 返回新来的num应该插入的位置
    private int binarySearch(List<Integer> array, Integer num) {
        if (array.size() == 0) return 0;
        int low = 0, high = array.size() - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (num == array.get(mid)) return mid;
            else if (num < array.get(mid)) high = mid - 1;
            else low = mid + 1;
        }
        return low;
    }
}
