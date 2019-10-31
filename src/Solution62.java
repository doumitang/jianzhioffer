public class Solution62 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private int count = 0;
    private TreeNode ans = null;

    /**
     * 中序遍历，用count记录遍历到第几个
     * 运行时间：26ms
     * 占用内存：9676k
     * @param pRoot
     * @param k
     * @return
     */
    public TreeNode KthNode(TreeNode pRoot, int k) {
        search(pRoot, k);
        return ans;
    }

    private boolean search(TreeNode pRoot, int k) {
        if (pRoot == null) return false;
        if (search(pRoot.left, k)) return true;
        count++;
        if (count == k) {
            ans = pRoot;
            return true;
        }
        if (search(pRoot.right, k)) return true;
        return false;
    }
}
