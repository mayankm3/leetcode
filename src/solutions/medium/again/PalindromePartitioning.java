package solutions.medium.again;

import java.util.ArrayList;
import java.util.List;

public class PalindromePartitioning {

    public static void main(String[] args) {
        String myString = "aabb";
        List<List<String>> result = partition(myString);
        for (List<String> stringList:result) System.out.println(stringList);
    }

    // https://leetcode.com/problems/palindrome-partitioning/description/
    // I had almost solved this one!
    // for better problem description & solution https://www.youtube.com/watch?v=3jvWodd7ht0
    // TC: O(n*(2^n)) See reply started by @lasanihussain8810
    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        palindromePartion(0, s, result, new ArrayList<String>());
        return result;
    }

    private static void palindromePartion(int index, String s, List<List<String>> result, ArrayList<String> myList) {
        if (index==s.length()){
            result.add(new ArrayList<>(myList));
            return;
        }

        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i)){
                String myString = s.substring(index, i+1);
                myList.add(myString);
                // https://youtu.be/WBgsABoClE0?&t=797 on why i?
                palindromePartion(i+1, s, result, myList);  // my only mistake, I passed index+1 :(
                myList.remove(myList.size()-1);
            }
        }
    }

    private static boolean isPalindrome(String myString, int start, int end){
        while (start<=end){
            if (myString.charAt(start++) != myString.charAt(end--))
                return false;
        }
        return true;
    }
}
