public class Solution13 {
    /**
     * 类似于插入排序，O(n^2)
     * offer书第21题，没有要求保证奇数和奇数，偶数和偶数之间的相对位置不变
     * @param array
     */
    public void reOrderArray(int [] array) {
        if (array == null || array.length < 2) return;
        for (int i = 1; i < array.length; i++) {
            if (array[i] % 2 == 1) {
                int temp = array[i];
                int j = i;
                // 整体后移
                while (j > 0 && array[j - 1] % 2 == 0) {
                    array[j] = array[j - 1];
                    j--;
                }
                // 将当前的奇数插入到 j 位置
                array[j] = temp;
            }
        }
    }

    public static void main(String[] args) {
        Solution13 solution13 = new Solution13();
        int[] array = {1,2,3,4,5,6,7};
        solution13.reOrderArray(array);
    }
}
