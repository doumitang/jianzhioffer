public class Solution35 {
    private int[] temp = null;
    private int ans = 0;

    /**
     * 大数在原数组中的位置需要在小数的前面，归并排序法
     * @param array
     * @return
     */
    public int InversePairs(int [] array) {
        temp = new int[array.length];
        mergeSort(array, 0, array.length - 1);
        return ans;
    }

    private void mergeSort(int[] array, int left, int right) {
        if (left >= right) return;
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid + 1, right);
        merge(array, left, mid, right);
    }

    private void merge(int[] array, int left, int mid, int right) {
        int indexLeft = left, indexRight = mid + 1, index = left;
        while (indexLeft <= mid && indexRight <= right) {
            if (array[indexLeft] > array[indexRight]) {
                ans = (ans + mid - indexLeft+ 1) % 1000000007;
                temp[index++] = array[indexRight++];
            } else {
                temp[index++] = array[indexLeft++];
            }
        }
        while (indexLeft <= mid) {
            temp[index++] = array[indexLeft++];
        }
        while (indexRight <= right) {
            temp[index++] = array[indexRight++];
        }
        for (int i = left; i <= right; i++) {
            array[i] = temp[i];
        }
    }

    public static void main(String[] args) {
        Solution35 solution35 = new Solution35();
        int[] array = {1,2,3,4,5,6,7,0};
        System.out.println(solution35.InversePairs(array));
    }
}
