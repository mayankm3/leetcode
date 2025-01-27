package solutions.medium.again;

import java.util.Stack;

public class MinStack {

    // https://leetcode.com/problems/min-stack/description/
    // GPT assisted solution
    // I submitted multiple times and kept improving based on hints and new test cases
    private Stack<Integer> stack;
    private Stack<Integer> auxiliaryStack;

    public MinStack() {
        stack = new Stack<>();
        auxiliaryStack = new Stack<>();
    }

    public void push(int val) {
        stack.add(val);
        if (auxiliaryStack.isEmpty()) {
            auxiliaryStack.add(val);
        }
        else if (val <= auxiliaryStack.peek()){
            auxiliaryStack.add(val);
        }
    }

    public void pop() {
        int lastEle = stack.pop();

        if (lastEle == auxiliaryStack.peek()){
            auxiliaryStack.pop();
        }
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return auxiliaryStack.peek();
    }
}
