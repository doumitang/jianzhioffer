import java.util.Stack;

public class Solution5 {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    public void push(int node) {
        stack1.push(node);
    }

    public int pop() {
        if (stack2.size() == 0) change();
        return stack2.pop();
    }

    private void change() {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
    }
}
