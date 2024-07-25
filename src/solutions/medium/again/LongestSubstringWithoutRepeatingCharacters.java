package solutions.medium.again;

import java.util.HashMap;

public class LongestSubstringWithoutRepeatingCharacters {

    // https://www.youtube.com/watch?v=-zSxTJkcdAo
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    public int lengthOfLongestSubstring(String s) {
        int left = 0, right = 0;
        int maxLength = 0;

        HashMap<Character, Integer> hashMap = new HashMap<>();
        while (right < s.length()){
            char c = s.charAt(right);

            if (hashMap.containsKey(c)){
                if (left <= hashMap.get(c)){
                    left = hashMap.get(c) + 1;
                }
            }

            maxLength = Math.max(maxLength, right - left + 1);
            hashMap.put(s.charAt(right), right);
            right++;
        }

        return maxLength;
    }
}
