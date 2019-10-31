import java.util.ArrayList;
import java.util.Comparator;

public class Solution24 {

    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    private ArrayList<ArrayList<Integer>> ans;

    /**
     * 回溯（递归），注意路径一直要到叶节点
     * @param root
     * @param target
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindPath(TreeNode root, int target) {
        ans = new ArrayList<>();
        recursion(root, new ArrayList<Integer>(), target);
        return ans;
    }

    private void recursion(TreeNode root, ArrayList<Integer> temp, int target) {
        if (root == null) return;
        temp.add(root.val);
        if (root.val == target && root.left == null && root.right == null) ans.add(new ArrayList<>(temp));
        recursion(root.left, temp, target - root.val);
        recursion(root.right, temp, target - root.val);
        temp.remove(temp.size() - 1);
    }

    public static void main(String[] args) {
        Solution24 solution24 = new Solution24();
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(7);
        treeNode.right = new TreeNode(12);
        solution24.FindPath(treeNode, 15);
    }
}
