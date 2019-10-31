public class Solution26_2 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private TreeNode pre = null;

    /**
     * 右中左遍历，记录pre和当前节点进行双向连接，节约了空间复杂度
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        recursion(pRootOfTree);
        return pre;
    }

    private void recursion(TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        Convert(pRootOfTree.right);
        if (pre == null) pre = pRootOfTree;
        else {
            pre.left = pRootOfTree;
            pRootOfTree.right = pre;
            pre = pRootOfTree;
        }
        Convert(pRootOfTree.left);
    }
}
