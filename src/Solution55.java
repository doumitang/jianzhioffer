public class Solution55 {
    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 分析好那些数学关系就完事了
     * 运行时间：18ms
     * 占用内存：9500k
     * @param pHead
     * @return
     */
    public ListNode EntryNodeOfLoop(ListNode pHead) {
        if (pHead == null) return null;
        ListNode slow = pHead;
        if (pHead.next == null) return null;
        ListNode fast = pHead.next;
        while (slow != fast) {
            if (slow == null || fast == null || fast.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }
        fast = pHead;
        slow = slow.next;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
