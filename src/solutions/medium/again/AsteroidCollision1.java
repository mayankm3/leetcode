package solutions.medium.again;

import java.util.ArrayDeque;
import java.util.Deque;

public class AsteroidCollision1 {

    // https://leetcode.com/problems/asteroid-collision/
    // https://www.youtube.com/watch?v=_eYGqw_VDR4
    // I solved 90% of it but I couldn't pass striver's TCs
    // TC1: -18,-19
    // TC2: 17,-19
    // TC2: 20,-19; -19 gets ignored in this case, LoL
    // https://leetcode.com/problems/asteroid-collision/solutions/193403/java-easy-to-understand-solution-by-daij-ijv6/comments/1017258
    // TC: O(2n)
    public int[] asteroidCollision(int[] asteroids) {
        Deque<Integer> stack = new ArrayDeque<>();  // https://stackoverflow.com/questions/12524826/why-should-i-use-deque-over-stack

        for (int asteroid : asteroids) {
            if (asteroid > 0) {
                stack.push(asteroid);
            } else {
                int absAsteriod = Math.abs(asteroid);
                while (!stack.isEmpty() && stack.peek() > 0 && absAsteriod > stack.peek()) {
                    stack.pop();
                }
                if (stack.isEmpty() || stack.peek() < 0) {
                    stack.push(asteroid);   // add will give error for TC [4,7,1,1,2,-3,-7,17,15,-18,-19]
                                            // Since I used deque
                }
                else if (absAsteriod == stack.peek()) {
                    stack.pop();
                }
            }
        }


        int stackSize = stack.size();
        int[] res = new int[stackSize];
        for (int i = stackSize-1; i >= 0; i--) {
            res[i] = stack.pop();
        }
        return res;
    }
}
