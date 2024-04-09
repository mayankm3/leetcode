package solutions.easy.again;

public class LongestCommonPrefix {
    // Write a function to find the longest common prefix string amongst an array of strings.
    public static void main(String[] args) {
        String[] strs1 = {"flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs1));

        String[] strs2 = {"dog","racecar","car"};
        System.out.println(longestCommonPrefix(strs2));
    }

    public static String longestCommonPrefix(String[] strs) {
        // Vertical scanning

        // Time complexity : O(S) , where S is the sum of all characters in all strings. In the worst
        // case there will be n equal strings with length m and the algorithm performs S=m*⋅n character comparisons.
        // in the best case there are at most n*minLen comparisons where minLen is the length of the shortest string in the array.
        if (strs == null || strs.length == 0) return "";
        for (int i = 0; i < strs[0].length(); i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if(strs[j].length() == i || strs[j].charAt(i) != c){
                    return strs[0].substring(0, i);
                }
            }
        }

        // control will reach here if two strings are same e.g., {"flower","flower"}
        return strs[0];
    }
}
