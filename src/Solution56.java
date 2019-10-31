public class Solution56 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 找到第一个与自己的pre不相等的节点cur
     * p.next = cur
     * 如果cur和cur.next不相等的话，p = cur
     * pre = cur, cur = cur.next
     *
     * 运行时间：22ms
     * 占用内存：9548k
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode p = dummy, pre = dummy, cur = pHead;
        while (true) {
            // 找到第一个与其pre不相等的节点
            while (cur != null && pre.val == cur.val) {
                pre = cur;
                cur = cur.next;
            }
            p.next = cur;
            if (cur == null) return dummy.next;
            if (cur.next != null && cur.val != cur.next.val) p = cur;
            pre = cur;
            cur = cur.next;
            if (cur == null) return dummy.next;
        }
    }

    public static void main(String[] args) {
        Solution56 solution56 = new Solution56();
        ListNode pHead = new ListNode(1);
        pHead.next = new ListNode(2);
        pHead.next.next = new ListNode(3);
        pHead.next.next.next = new ListNode(3);
        pHead.next.next.next.next = new ListNode(4);
        pHead.next.next.next.next.next = new ListNode(4);
        pHead.next.next.next.next.next.next = new ListNode(5);
        solution56.deleteDuplication(pHead);
    }
}
