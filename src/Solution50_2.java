public class Solution50_2 {
    /**
     * 注意题目中的：在一个长度为n的数组里的所有数字都在0到n-1的范围内
     * 意味着每一个数值都可以对应到一个位置
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) return false;
        int i = 0;
        while (i < length) {
            int val = numbers[i];
            if (i == val) {
                i++;
            } else if (val != numbers[val]) {
                swap(numbers, i, val);
            } else {
                duplication[0] = val;
                return true;
            }
        }
        return false;
    }

    /**
     * 当一个数字被访问过后，可以设置对应位上的数 + n，之后再遇到相同的数时，会发现对应位上的数已经大于等于n了，那么直接返回这个数即可。
     * @param numbers
     * @param length
     * @param duplication
     * @return
     */
    public boolean duplicate3(int numbers[],int length,int [] duplication) {
        if (numbers == null || length == 0) return false;
        for (int i = 0; i < length; i++) {
            int index = numbers[i];
            index %= length;
            if (numbers[index] >= length) {
                duplication[0] = index;
                return true;
            }
            numbers[index] += length;
        }
        return false;
    }

    private void swap(int[] numbers, int p1, int p2) {
        int temp = numbers[p1];
        numbers[p1] = numbers[p2];
        numbers[p2] = temp;
    }

    public static void main(String[] args) {
        Solution50_2 solution50_2 = new Solution50_2();
        int[] nums = {2,1,3,0,4};
        solution50_2.duplicate(nums, 5, new int[1]);
    }
}
