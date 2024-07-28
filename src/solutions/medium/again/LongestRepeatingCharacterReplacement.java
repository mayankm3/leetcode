package solutions.medium.again;

public class LongestRepeatingCharacterReplacement {

    // https://leetcode.com/problems/longest-repeating-character-replacement/
    // TC: O(N)
    // SC: O(26)
    public static void main(String[] args) {
        String s = "AAABBCCD";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k){
        int left = 0, right = 0, maxLength = 0, maxFrequency = 0;
        int[] frequency = new int[26];
        char[] chars = s.toCharArray();

        while (right < s.length()){
            char myChar = chars[right];
            frequency[myChar - 'A']++;
            maxFrequency = Math.max(maxFrequency, frequency[myChar - 'A']);

            int changes = (right-left+1) - maxFrequency;
            if (changes <= k){
                maxLength = Math.max(maxLength, right-left+1);
            }
            else {
                // trimming down size of window
                frequency[chars[left] - 'A']--;
                left++;
            }

            right++;
        }

        return maxLength;
    }
}
