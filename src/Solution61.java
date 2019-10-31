public class Solution61 {
    static class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * offer书第37题
     * 先序遍历，关键在于把index弄对
     *
     * 运行时间：33ms
     * 占用内存：9596k
     * @param root
     * @return
     */
    String Serialize(TreeNode root) {
        if (root == null) return "#";
        return root.val + "!" + Serialize(root.left) + Serialize(root.right);
    }

    private int index = 0;
    private String string;

    TreeNode Deserialize(String str) {
        string = str;
        TreeNode root = null;
        return recursion(root);
    }

    private TreeNode recursion(TreeNode treeNode) {
        char ch = string.charAt(index);
        if (ch == '#') {
            index += 1;
            return null;
        }
        int pre = index;
        while (string.charAt(index) != '!') index++;
        treeNode = new TreeNode(Integer.valueOf(string.substring(pre, index)));
        index++;
        treeNode.left = recursion(treeNode.left);
        treeNode.right = recursion(treeNode.right);
        return treeNode;
    }

    public static void main(String[] args) {
        Solution61 solution61 = new Solution61();
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(6);
        root.right = new TreeNode(10);
        root.left.left = new TreeNode(5);
        root.left.right = new TreeNode(7);
        root.right.left = new TreeNode(9);
        root.right.right = new TreeNode(11);

        String str = solution61.Serialize(root);
        System.out.println(str);
        TreeNode treeNode = solution61.Deserialize(str);
        Print(treeNode);
    }

    private static void Print(TreeNode treeNode) {
        if (treeNode == null) return;
        System.out.print(treeNode.val);
        Print(treeNode.left);
        Print(treeNode.right);
    }
}
