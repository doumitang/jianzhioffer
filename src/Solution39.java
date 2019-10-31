public class Solution39 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;
        }
    }

    private TreeNode pre = null;

    /**
     * 递归调用TreeDepth()递归函数，重复遍历太多
     * @param root
     * @return
     */
    public boolean IsBalanced_Solution(TreeNode root) {
        return isDepthValid(root);
    }

    private boolean isDepthValid(TreeNode root) {
        if (root == null) return true;
        return Math.abs(TreeDepth(root.left) - TreeDepth(root.right)) <= 1 && isDepthValid(root.left) && isDepthValid(root.right);
    }

    private int TreeDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + Math.max(TreeDepth(root.left), TreeDepth(root.right));
    }

    private boolean isBinSearch(TreeNode root) {
        if (root == null) return true;
        if (!isBinSearch(root.left)) return false;
        if (pre != null && pre.val > root.val) return false;
        pre = root;
        if (!isBinSearch(root.right)) return false;
        return true;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        Solution39 solution39 = new Solution39();
        System.out.println(solution39.IsBalanced_Solution(root));
    }
}
