public class Solution36_2 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1, p2 = pHead2;
        // 每次改变p1和p2的时候都应该判断一下
        while (p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
            if (p1 == p2) break; // null可以和null相等
            if (p1 == null) p1 = pHead2;
            if (p2 == null) p2 = pHead1;
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(3);
        p1.next.next.next = new ListNode(4);
        ListNode p2 = new ListNode(5);
        p2.next = new ListNode(6);
        p2.next.next = new ListNode(7);
        Solution36_2 solution36_2 = new Solution36_2();
        System.out.println(solution36_2.FindFirstCommonNode(p1, p2));
    }
}
