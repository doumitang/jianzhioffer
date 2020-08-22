public class Solution13_2 {
    /**
     * 时间复杂度一样O(n^2)，但是这样好理解一点
     *
     * 初始化操作：记录一个变量i表示已经将奇数放好的下一个位置，显然最开始i=0,表示还没有一个奇数放好。
     * j 表示数组的下标，初始值为0， 表示从下标0开始遍历。
     *
     * 如果遇到偶数，j++
     * 如果遇到奇数,假设位置为j，就将此奇数插入到i所指的位置，然后i往后移动一个位置，在插入之前，显然会涉及到数据的移动，也就是将[i,j-1]整体往后移动。
     * 直到整个数组遍历完毕，结束
     * @param array
     */
    public void reOrderArray(int[] array) {
        int i = 0;
        for (int j = 0; j < array.length; ++j) {
            if ((array[j] & 1) == 1) {
                int tmp = array[j];
                for (int k = j - 1; k >= i; --k) {
                    array[k + 1] = array[k];
                }
                array[i++] = tmp;
            }
        }
    }
}
