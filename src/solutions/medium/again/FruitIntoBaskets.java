package solutions.medium.again;

import java.util.HashMap;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits){
        int left = 0, right = 0, maxNumOfFruits = 0;

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        while (right < fruits.length){
            hashMap.put(fruits[right], hashMap.getOrDefault(fruits[right], 0)+1);

            if (hashMap.size() > 2){
                hashMap.put(fruits[left], hashMap.get(fruits[left])-1);
                if (hashMap.get(fruits[left]) == 0){
                    hashMap.remove(fruits[left]);
                }
                left++;
            }

            if (hashMap.size() <= 2) {
                maxNumOfFruits = Math.max(maxNumOfFruits, right-left+1);
            }

            right++;
        }

        return maxNumOfFruits;
    }
}
