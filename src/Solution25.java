import java.util.HashMap;
import java.util.Map;

public class Solution25 {

    static class RandomListNode {
        int label;
        RandomListNode next = null;
        RandomListNode random = null;

        RandomListNode(int label) {
            this.label = label;
        }
    }

    private Map<RandomListNode, RandomListNode> map = new HashMap<>();

    /**
     * 迭代法，关键在于一路的next为主线，random为支线
     * @param pHead
     * @return
     */
    public RandomListNode Clone(RandomListNode pHead) {
        if (pHead == null) return null;
        RandomListNode p = new RandomListNode(pHead.label);
        RandomListNode p1 = pHead, p2 = p;
        while (p1 != null) {
            if (p1.next != null) {
                if (!map.containsKey(p1.next)) {
                    p2.next = new RandomListNode(p1.next.label);
                    map.put(p1.next, p2.next);
                } else {
                    p2.next = map.get(p1.next);
                }
            }
            if (p1.random != null) {
                if (!map.containsKey(p1.random)) {
                    p2.random = new RandomListNode(p1.random.label);
                    map.put(p1.random, p2.random);
                } else {
                    p2.random = map.get(p1.random);
                }
            }
            p1 = p1.next;
            p2 = p2.next;
        }
        return p;
    }
}
