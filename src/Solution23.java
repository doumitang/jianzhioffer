public class Solution23 {
    /**
     * 递归，关键在于找到右子树的位置，本质为分治法，时间复杂度O(n*logn)
     * @param sequence
     * @return
     */
    public boolean VerifySquenceOfBST(int [] sequence) {
        if (sequence == null || sequence.length == 0) return false;
        return recursion(sequence, 0, sequence.length - 1);
    }

    private boolean recursion(int[] sq, int left, int right) {
        if (left >= right) return true;
        int rootVal = sq[right];
        int index = findRightSubTree(sq, left, right - 1, rootVal);
        if (!isValidRightSubTree(sq, index, right - 1, rootVal)) return false;
        return recursion(sq, left, index - 1) && recursion(sq, index, right - 1);
    }

    private boolean isValidRightSubTree(int[] sq, int left, int right, int val) {
        for (int i = left; i <= right; i++) {
            if (sq[i] < val) return false;
        }
        return true;
    }

    private int findRightSubTree(int[] sq, int left, int right, int rootVal) {
        for (int i = left; i <= right; i++) {
            if (sq[i] > rootVal) return i;
        }
        return right + 1;
    }

    public static void main(String[] args) {
        Solution23 solution23 = new Solution23();
        solution23.VerifySquenceOfBST(new int[]{4,8,6,12,16,14,10});
    }
}
