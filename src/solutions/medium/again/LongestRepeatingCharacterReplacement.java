package solutions.medium.again;

public class LongestRepeatingCharacterReplacement {

    public static void main(String[] args) {
        String s = "AAABBCCD";
        int k = 2;
        System.out.println(characterReplacement(s, k));
    }

    public static int characterReplacement(String s, int k){
        int left = 0, right = 0, maxLength = 0, maxFrequency = 0;
        int[] positions = new int[26];

        while (right < s.length()){
            char c = s.charAt(right);
            positions[c - 'A']++;
            maxFrequency = Math.max(maxFrequency, positions[c - 'A']);
            int changes = (right-left+1) - maxFrequency;
            if (changes <= k){
                maxLength = Math.max(maxLength, right-left+1);
            }
        }

        return maxLength;
    }
}
