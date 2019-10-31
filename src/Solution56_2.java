public class Solution56_2 {
    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 自己的想法在代码实现上有点麻烦，cur和自己的pre和next都要比，参考题解只用和自己的next比
     * 如果cur和cur.next相等，则找到第一个和其next不等的cur
     * cur = cur.next
     * pre.next = cur.next
     * 如果cur和cur.next不相等，则pre = cur, cur = cur.next
     *
     * 运行时间：20ms
     * 占用内存：9684k
     * @param pHead
     * @return
     */
    public ListNode deleteDuplication(ListNode pHead) {
        if (pHead == null || pHead.next == null) return pHead;
        ListNode dummy = new ListNode(0);
        dummy.next = pHead;
        ListNode pre = dummy, cur = pre.next;
        while (cur != null) {
            if (cur.next != null && cur.val == cur.next.val) {
                while (cur.next != null && cur.val == cur.next.val) cur = cur.next;
                cur = cur.next;
                pre.next = cur;
            } else {
                pre = cur;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}
