package solutions.medium.again;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan2 {
    // previous greater element
    // https://leetcode.com/problems/online-stock-span/description/
    // https://leetcode.com/problems/online-stock-span/solutions/640358/java-solution-with-visualization-and-eas-wfu8/
    private Deque<int[]> stack; // [price, index]

    public OnlineStockSpan2() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        int span = 1;
        while (!stack.isEmpty() && price >= stack.peekLast()[0]){
            span += stack.peekLast()[1];
            stack.removeLast();
        }

        stack.addLast(new int[]{price, span});
        return span;
    }
}
