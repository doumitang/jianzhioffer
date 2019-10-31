public class Solution58 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 构造出镜像树，再进行比较，有空间复杂度
     *
     * 运行时间：16ms
     * 占用内存：9268k
     * @param pRoot
     * @return
     */
    boolean isSymmetrical(TreeNode pRoot) {
        if (pRoot == null) return true;
        TreeNode mirror = getMirrorTree(pRoot);
        return dfs(pRoot, mirror);
    }

    private TreeNode getMirrorTree(TreeNode pRoot) {
        if (pRoot == null) return null;
        TreeNode root = new TreeNode(pRoot.val);
        root.left = getMirrorTree(pRoot.right);
        root.right = getMirrorTree(pRoot.left);
        return root;
    }

    private boolean dfs(TreeNode pRoot, TreeNode mirror) {
        if (pRoot == null && mirror == null) return true;
        if (pRoot != null && mirror != null && pRoot.val == mirror.val) return dfs(pRoot.left, mirror.left) && dfs(pRoot.right, mirror.right);
        return false;
    }

    public static void main(String[] args) {
        Solution58 solution58 = new Solution58();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(5);
        System.out.println(solution58.isSymmetrical(root));
    }
}
