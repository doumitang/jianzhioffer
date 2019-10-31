import java.util.ArrayList;
import java.util.List;

public class Solution26 {

    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }
    }

    /**
     * 左中右（中序）遍历，顺序存储节点指针，但是空间复杂度为O(n)
     * @param pRootOfTree
     * @return
     */
    public TreeNode Convert(TreeNode pRootOfTree) {
        List<TreeNode> treeNodes = new ArrayList<>();
        dfs(treeNodes, pRootOfTree);
        for (int i = 0; i < treeNodes.size(); i++) {
            if (i == 0) treeNodes.get(i).left = null;
            else treeNodes.get(i).left = treeNodes.get(i - 1);
            if (i == treeNodes.size() - 1) treeNodes.get(i).right = null;
            else treeNodes.get(i).right = treeNodes.get(i + 1);
        }
        if (treeNodes.size() == 0) return null;
        return treeNodes.get(0);
    }

    private void dfs(List<TreeNode> treeNodes, TreeNode pRootOfTree) {
        if (pRootOfTree == null) return;
        dfs(treeNodes, pRootOfTree.left);
        treeNodes.add(pRootOfTree);
        dfs(treeNodes, pRootOfTree.right);
    }
}
