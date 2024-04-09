package solutions.easy.again;

import java.util.LinkedList;
import java.util.Queue;

public class ImplementStackusingQueues {

    // https://leetcode.com/problems/implement-stack-using-queues/description/
    // https://leetcode.com/problems/implement-stack-using-queues/solutions/62516/concise-1-queue-java-c-python/
    // https://www.youtube.com/watch?v=b749wwxlQmA diagram only

    // Understand how LL operations in Java work by below program
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();

        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.add(9);

        System.out.println(linkedList.remove());    // removes what? :)
    }

    private static class MyStack {
        Queue<Integer> integerQueue = new LinkedList<>();

        public MyStack() {

        }

        public void push(int x) {
            integerQueue.add(x);
            for (int i = 1; i < integerQueue.size(); i++) {
                integerQueue.add(integerQueue.remove());
            }
        }

        public int pop() {
            return integerQueue.remove();
        }

        public int top() {
            return integerQueue.peek();
        }

        public boolean empty() {
            return integerQueue.isEmpty();
        }
    }


}
