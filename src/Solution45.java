import java.util.Arrays;

public class Solution45 {
    /**
     * 排序，统计0的个数，遍历过程消耗0的个数
     * @param numbers
     * @return
     */
    public boolean isContinuous(int [] numbers) {
        if (numbers == null || numbers.length != 5) return false;
        Arrays.sort(numbers);
        int count = 0, pre = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] == 0) count++;
            else {
                if (numbers[i] == pre) return false; // 有重复数字
                if (pre != 0) {
                    count = count - (numbers[i] - pre - 1);
                }
                pre = numbers[i];
            }
        }
        return count >= 0;
    }

    public static void main(String[] args) {
        Solution45 solution45 = new Solution45();
        int[] array = {1,3,2,5,4};
        solution45.isContinuous(array);
    }
}
