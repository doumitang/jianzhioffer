import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Solution60 {
    class TreeNode {
        int val = 0;
        TreeNode left = null;
        TreeNode right = null;

        public TreeNode(int val) {
            this.val = val;

        }

    }

    /**
     * 关键在于记录下当前queue的长度
     *
     * 运行时间：24ms
     * 占用内存：9692k
     * @param pRoot
     * @return
     */
    public ArrayList<ArrayList<Integer>> Print(TreeNode pRoot) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        if (pRoot == null) return ans;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(pRoot);
        while (!queue.isEmpty()) {
            int size = queue.size(); // 记录下当前queue的长度
            ArrayList<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.poll();
                temp.add(treeNode.val);
                if (treeNode.left != null) queue.offer(treeNode.left);
                if (treeNode.right != null) queue.offer(treeNode.right);
            }
            ans.add(temp);
        }
        return ans;
    }
}
