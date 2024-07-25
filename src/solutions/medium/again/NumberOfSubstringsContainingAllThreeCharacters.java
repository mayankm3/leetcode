package solutions.medium.again;

public class NumberOfSubstringsContainingAllThreeCharacters {

    public int numberOfSubstrings(String s){
        int count = 0;
        int[] last = {-1, -1, -1};
        char[] letters = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            char letter = letters[i];
            last[letter - 'a'] = i;

            count += 1 + Math.min(last[0], Math.min(last[1], last[2]));
        }

        return count;
    }
}
