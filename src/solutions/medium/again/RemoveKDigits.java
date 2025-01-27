package solutions.medium.again;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveKDigits {

    // https://leetcode.com/problems/remove-k-digits/description/
    // https://www.youtube.com/watch?v=jmbuRzYPGrg&list=PLgUwDviBIf0pOd5zvVVSzgpo6BaCpHT9c&index=15
    // https://leetcode.com/problems/remove-k-digits/solutions/88708/straightforward-java-solution-using-stac-2ny3/comments/227568
    public String removeKdigits(String num, int k) {
        char[] chars = num.toCharArray();
        Deque<Character> stack = new ArrayDeque<>();

        for (char c:chars) {
            while (!stack.isEmpty() && c<stack.peekLast() && k>0){
                stack.removeLast();
                k--;
            }
            stack.addLast(c);   // Since I used deque, don't use push(), it will push to beginning
        }

        // TC: 5,1,2,3,4,5,6 and k = 4
        while (k > 0){
            stack.removeLast();
            k--;
        }

        // TC: 10200
        while (!stack.isEmpty() && stack.peekFirst() == '0'){
            stack.removeFirst();
        }

        int stackSize = stack.size();
        // TC: 5,1,2 and k = 3
        if(stackSize == 0) return "0";

        StringBuilder stringBuilder = new StringBuilder(stackSize);
        while(!stack.isEmpty()) {
            stringBuilder.append(stack.removeFirst());
        }

        return stringBuilder.toString();
    }
}
