public class Solution16 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 不需要额外空间，直接在这两个链表上进行操作
     * @param list1
     * @param list2
     * @return
     */
    public ListNode Merge(ListNode list1,ListNode list2) {
        ListNode ans = new ListNode(0);
        ListNode p1 = list1, p2 = list2, p = ans;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }
        if (p1 == null) {
            p.next = p2;
        }
        if (p2 == null) {
            p.next = p1;
        }
        return ans.next;
    }
}
