import java.util.Stack;

public class Solution20 {
    private Stack<Integer> stack = new Stack<>();
    private Stack<Integer> stackMin = new Stack<>();

    /**
     * offer书第30题，建立一个辅助栈，保存每层对应的最小值
     * @param node
     */
    public void push(int node) {
        stack.push(node);
        if (stackMin.isEmpty() || node < stackMin.peek()) stackMin.push(node);
        else stackMin.push(stackMin.peek());
    }

    public void pop() {
        if (!stack.isEmpty()) stack.pop();
        if (!stackMin.isEmpty()) stackMin.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return stackMin.peek();
    }
}
