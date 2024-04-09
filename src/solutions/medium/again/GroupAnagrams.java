package solutions.medium.again;

import java.util.*;

public class GroupAnagrams {

    // time complexity is O(m*n)
    // https://leetcode.com/problems/group-anagrams
    public static void main(String[] args) {
        List<String> list = Arrays.asList("eat","tea","tan","ate","nat","bat");
        String[] strArr1 = list.toArray(new String[0]);
        System.out.println(groupAnagrams(strArr1));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        if (strs == null || strs.length == 0) return new ArrayList<>();
        Map<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] ca = new char[26];
            for (char c : s.toCharArray()) {
                ca[c - 'a']++;  // incrementing at nth position by 1
            }
            String keyStr = String.valueOf(ca);
            if (!map.containsKey(keyStr)) {
                map.put(keyStr, new ArrayList<>());
            }
            map.get(keyStr).add(s);
        }
        return new ArrayList<>(map.values());
    }
}
