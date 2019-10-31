/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution4 {

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x; }
    }

    public TreeNode reConstructBinaryTree(int[] pre,int[] in) {
        return recursion(pre, 0, pre.length - 1, in, 0, in.length - 1);
    }

    private TreeNode recursion(int[] pre, int leftPre, int rightPre, int[] in, int leftIn, int rightIn) {
        if (leftPre > rightPre || leftIn > rightIn) return null;
        TreeNode treeNode = new TreeNode(pre[leftPre]);
        for (int pos = leftIn; pos <= rightIn; pos++) {
            if (in[pos] == pre[leftPre]) {
                int length = pos - leftIn;
                treeNode.left = recursion(pre, leftPre + 1, leftPre + length, in, leftIn, pos - 1);
                treeNode.right = recursion(pre, leftPre + length + 1, rightPre, in, pos + 1, rightIn);
                break;
            }
        }
        return treeNode;
    }

    public static void main(String[] args) {
        int[] pre = {1,2,4,7,3,5,6,8};
        int[] in = {4,7,2,1,5,3,8,6};
        Solution4 solution4 = new Solution4();
        solution4.reConstructBinaryTree(pre, in);
    }
}