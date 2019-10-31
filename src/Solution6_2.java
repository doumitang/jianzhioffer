public class Solution6_2 {
    /**
     * 二分法
     * @param array
     * @return
     */
    public int minNumberInRotateArray(int [] array) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            if (array[left] < array[right]) return array[left];
            int mid = (left + right) / 2;
            System.out.println(array[left] + ", " + array[right] + ", " + array[mid]);
            if (array[mid] > array[left]) left = mid + 1;
            else if (array[mid] < array[left]) right = mid;
            else left++;
        }
        return array[left];
    }

    public static void main(String[] args) {
        Solution6_2 solution6_2 = new Solution6_2();
        int[] array = {6501,6828,6963,7036,7422,7674,8146,8468,8704,8717,9170,9359,9719,9895,9896,9913,9962,154,293,334,492,1323,1479,1539,1727,1870,1943,2383,2392,2996,3282,3812,3903,4465,4605,4665,4772,4828,5142,5437,5448,5668,5706,5725,6300,6335};
        System.out.println(solution6_2.minNumberInRotateArray(array));
    }
}
