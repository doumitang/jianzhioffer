import java.util.ArrayList;
import java.util.Stack;

public class Solution59 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 双栈法，交替存储前一层和后一层的节点
     *
     * 运行时间：23ms
     * 占用内存：9668k
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;
        Stack<TreeNode> stack1 = new Stack<>();
        Stack<TreeNode> stack2 = new Stack<>();
        ArrayList<Integer> temp = new ArrayList<>();
        boolean toRight = true;
        stack1.push(pRoot);
        temp.add(pRoot.val);
        ans.add(new ArrayList<>(temp));
        temp.clear();
        while (!stack1.isEmpty() || !stack2.isEmpty()) {
            System.out.println(stack1.size() + ", " + stack2.size());
            if (toRight) {
                while (!stack1.isEmpty()) {
                    TreeNode treeNode = stack1.pop();
                    if (treeNode.right != null) {
                        stack2.push(treeNode.right);
                        temp.add(treeNode.right.val);
                    }
                    if (treeNode.left != null) {
                        stack2.push(treeNode.left);
                        temp.add(treeNode.left.val);
                    }
                }
            } else {
                while (!stack2.isEmpty()) {
                    TreeNode treeNode = stack2.pop();
                    if (treeNode.left != null) {
                        stack1.push(treeNode.left);
                        temp.add(treeNode.left.val);
                    }
                    if (treeNode.right != null) {
                        stack1.push(treeNode.right);
                        temp.add(treeNode.right.val);
                    }
                }
            }
            if (!temp.isEmpty()) {
                ans.add(new ArrayList<>(temp));
                temp.clear();
            }
            toRight = !toRight;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution59 solution59 = new Solution59();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);


        TreeNode root1 = new TreeNode(5);
        root1.left = new TreeNode(4);
        root1.left.left = new TreeNode(3);
        root1.left.left.left = new TreeNode(2);
        System.out.println(solution59.Print(root1));
    }
}
