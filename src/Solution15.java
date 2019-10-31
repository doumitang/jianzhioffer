public class Solution15 {

    class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode ReverseList(ListNode head) {
        if (head == null) return null;
        if (head.next == null) return head;
        ListNode next = head.next;
        ListNode ans = ReverseList(next);
        next.next = head;
        head.next = null;
        return ans;
    }
}
