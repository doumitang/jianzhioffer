public class Solution6 {
    public int minNumberInRotateArray(int [] array) {
        int pre = Integer.MIN_VALUE;
        for (int value : array) {
            if (value < pre) return value;
            pre = value;
        }
        return array[0];
    }
}
