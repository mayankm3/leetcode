package solutions.medium.again;

import java.util.ArrayDeque;
import java.util.Deque;

public class OnlineStockSpan1 {
    // previous greater element
    // https://leetcode.com/problems/online-stock-span/description/
    // https://www.youtube.com/watch?v=eay-zoSRkVc&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=16
    // TC: O(2N); TC: 100,99,98,...3,2,1,101 :)
    // SC: O(N)
    // This solution is easier to remember
    private Deque<int[]> stack; // [price, index]
    private int index;

    public OnlineStockSpan1() {
        stack = new ArrayDeque<>();
    }

    public int next(int price) {
        while (!stack.isEmpty() && price >= stack.peekLast()[0]){
            stack.removeLast();
        }
        int prevGreaterIndex = stack.isEmpty()? -1:stack.peekLast()[1];
        int span = index-prevGreaterIndex;

        stack.addLast(new int[]{price, index++});

        return span;
    }
}
