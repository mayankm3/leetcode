package solutions.easy.again;

import java.util.Stack;

public class ImplementQueueusingStacks {

    // https://leetcode.com/problems/implement-queue-using-stacks/description/
    // https://leetcode.com/problems/implement-queue-using-stacks/solutions/64206/short-o-1-amortized-c-java-ruby/
    // https://youtu.be/3Et9MrMc02A&t=308
    // I also thought of the same thing in 10 minutes.
    // TC: O(1) amortised since push from 1 to 2 occurs only sometimes
    private static class MyQueue{
        Stack<Integer> integerStack1 = new Stack<>();
        Stack<Integer> integerStack2 = new Stack<>();

        public MyQueue() {

        }

        public void push(int x) {
            integerStack1.push(x);
        }

        public int pop() {
            peek();
            return integerStack2.pop();
        }

        public int peek() {
            if (integerStack2.empty()){
                while (!integerStack1.empty()){
                    integerStack2.push(integerStack1.pop());
                }
            }

            return integerStack2.peek();
        }

        public boolean empty() {
            return integerStack1.empty() && integerStack2.empty();
        }
    }

}
