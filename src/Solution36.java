import java.util.List;

public class Solution36 {

    static class ListNode {
        int val;
        ListNode next = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    /**
     * 第一次遍历求出长度差，然后让长链表先走（基本原理正确，但是想法不够精妙）
     * @param pHead1
     * @param pHead2
     * @return
     */
    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) return null;
        ListNode p1 = pHead1, p2 = pHead2;
        int who = 0;
        while (true) {
            if (p1.next == null) {
                who = 1;
                break;
            }
            if (p2.next == null) {
                who = 2;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        int delta = 0;
        switch (who) {
            case 1:
                while (p2 != null && p2 != p1) {
                    p2 = p2.next;
                    delta++;
                }
                if (p2 == null) return null;
                p1 = pHead1;
                p2 = pHead2;
                for (int i = 0; i < delta; i++) {
                    p2 = p2.next;
                }
                break;
            case 2:
                while (p1 != null && p1 != p2) {
                    p1 = p1.next;
                    delta++;
                }
                if (p1 == null) return null;
                p1 = pHead1;
                p2 = pHead2;
                for (int i = 0; i < delta; i++) {
                    p1 = p1.next;
                }
        }
        while (p1 != null && p2 != null && p1 != p2) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return (p1 == null || p2 == null) ? null : p1;
    }

    public static void main(String[] args) {
        ListNode p1 = new ListNode(1);
        p1.next = new ListNode(2);
        p1.next.next = new ListNode(3);
        p1.next.next.next = new ListNode(4);
        ListNode p2 = new ListNode(5);
        p2.next = new ListNode(6);
        p2.next.next = new ListNode(7);
        Solution36 solution36 = new Solution36();
        System.out.println(solution36.FindFirstCommonNode(p1, p2));
    }
}
