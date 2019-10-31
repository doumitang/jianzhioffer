import java.util.Stack;

public class Solution21 {
    /**
     * offer书第31题，用一个栈模拟，参考题解的写法，比书上简洁
     * @param pushA
     * @param popA
     * @return
     */
    public boolean IsPopOrder(int [] pushA,int [] popA) {
        int len = pushA.length, j = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0 ; i < len; i++) {
            stack.push(pushA[i]);
            // 把能弹出的都弹出
            while (!stack.isEmpty() && stack.peek() == popA[j]) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }
}
