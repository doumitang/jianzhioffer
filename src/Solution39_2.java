public class Solution39_2 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    /**
     * 这题的平衡二叉树只需要 左右子树的高度差 <= 1即可，定义不一样
     *
     * note:
     * 38题求二叉树深度的引申
     * 关键在于既要返回子树的深度，又要返回子树的有效性
     * 因此把深度作为返回值，非法时返回特殊深度-1
     * 精妙！
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return TreeDepth(root) != -1;
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        int depthLeft = TreeDepth(root.left);
        if (depthLeft == -1) return -1;
        int depthRight = TreeDepth(root.right);
        if (depthRight == -1) return -1;
        if (Math.abs(depthLeft - depthRight) > 1) return -1;
        return 1 + Math.max(depthLeft, depthRight);
    }
}
