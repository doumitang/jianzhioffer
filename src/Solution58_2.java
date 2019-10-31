public class Solution58_2 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 可以直接递归比较左子树和右子树，我都傻了~
     * 运行时间：16ms
     * 占用内存：9420k
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        return dfs(pRoot.left, pRoot.right);
    }


    private boolean dfs(TreeNode pRoot, TreeNode mirror) {
        if (pRoot == null && mirror == null) return true;
        if (pRoot != null && mirror != null && pRoot.val == mirror.val) return dfs(pRoot.left, mirror.right) && dfs(pRoot.right, mirror.left);
        return false;
    }
}
