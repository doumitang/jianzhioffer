import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *    public class ListNode {
 *        int val;
 *        ListNode next = null;
 *
 *        ListNode(int val) {
 *            this.val = val;
 *        }
 *    }
 *
 */
public class Solution3 {

    class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> ans = new ArrayList<>();
        ListNode p = listNode;
        while (p != null) {
            ans.add(0, p.val);
            p = p.next;
        }
        return ans;
    }
}
