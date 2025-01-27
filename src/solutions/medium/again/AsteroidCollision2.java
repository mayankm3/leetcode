package solutions.medium.again;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class AsteroidCollision2 {

    // https://leetcode.com/problems/asteroid-collision/
    // https://www.youtube.com/watch?v=_eYGqw_VDR4
    // I solved 90% of it but I couldn't pass striver's TCs
    // TC1: -18,-19
    // TC2: 17,-19
    // TC2: 20,-19; -19 gets ignored in this case, LoL
    // https://leetcode.com/problems/asteroid-collision/solutions/193403/java-easy-to-understand-solution-by-daij-ijv6/comments/1017258
    public int[] asteroidCollision(int[] asteroids) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < asteroids.length; i++) {
            int asteroid = asteroids[i];
            if (asteroid < 0){
                int absAsteriod = Math.abs(asteroid);
                while (!list.isEmpty() && absAsteriod>list.get(list.size()-1) && list.get(list.size()-1)>0){
                    list.remove(list.size()-1);
                }
                if (list.isEmpty()){
                    list.add(asteroid);
                }
                else if (absAsteriod<list.get(list.size()-1)) {
                    continue;
                }else if (absAsteriod == list.get(list.size()-1)) {
                    list.remove(list.size()-1);
                }
            }

            list.add(asteroid);
        }

        int listSize = list.size();
        int[] res = new int[listSize];
        for (int i = 0; i < listSize; i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
