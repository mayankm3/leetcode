package solutions.medium.again;

import java.util.HashMap;

public class LongestSubstringWithAtMostKDistinctCharacters {

    // TC: O(N)+O(log(256))
    public static void main(String[] args) {
        String s = "aaabbccdaaaaaa";
        int k = 2;
        System.out.println(lengthOfLongestSubstringKDistinct(s, k));
    }

    public static int lengthOfLongestSubstringKDistinct(String s, int k){
        int left = 0, right = 0, maxLength = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();

        while (right < s.length()){
            char c = s.charAt(right);
            hashMap.put(c, hashMap.getOrDefault(c, 0) + 1);

            if (hashMap.size() > k){
                char charAtLeft = s.charAt(left);
                hashMap.put(charAtLeft, hashMap.getOrDefault(charAtLeft, 0) - 1);
                if (hashMap.get(charAtLeft) == 0){
                    hashMap.remove(charAtLeft);
                }
                left++;
            }
            if (hashMap.size() <= k){
                maxLength = Math.max(maxLength, right-left+1);
            }

            right++;
        }

        return maxLength;
    }
}
