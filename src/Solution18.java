public class Solution18 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    public void Mirror(TreeNode root) {
        if (root == null) return;
        TreeNode left = root.left, right = root.right;
        root.left = right;
        root.right = left;
        Mirror(root.left);
        Mirror(root.right);
    }
}
