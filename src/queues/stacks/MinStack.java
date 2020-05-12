package queues.stacks;

import java.util.Stack;

class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minVals;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        stack = new Stack<>();
        minVals = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);

        if (minVals.isEmpty() || x <= minVals.peek())
            minVals.push(x);
    }

    public void pop() {
        if (stack.peek().equals(minVals.peek()))
            minVals.pop();

        stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minVals.peek();
    }
}