public class Solution57 {
    class TreeLinkNode {
        int val;
        TreeLinkNode left = null;
        TreeLinkNode right = null;
        TreeLinkNode next = null;

        TreeLinkNode(int val) {
            this.val = val;
        }
    }

    /**
     * 如果有右子树，返回右子树的最左下节点
     * 如果没有右子树，向上遍历parent，使得自己处于这个parent的左子树
     *
     * 运行时间：25ms
     * 占用内存：9748k
     * @param pNode
     * @return
     */
    public TreeLinkNode GetNext(TreeLinkNode pNode) {
        if (pNode == null) return null;
        TreeLinkNode temp = null;
        // 如果有右子树，返回右子树的最左下节点
        if (pNode.right != null) {
            temp = pNode.right;
            while (temp.left != null) temp = temp.left;
            return temp;
        }
        // 如果没有右子树，向上遍历parent，使得自己处于这个parent的左子树
        temp = pNode;
        TreeLinkNode parent = temp.next;
        while (parent != null && parent.left != temp) {
            temp = parent;
            parent = parent.next;
        }
        return parent;
    }
}
