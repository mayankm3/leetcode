package solutions.easy.again;

import java.util.HashMap;

public class RomanToInteger {

    public static void main(String[] args) {
        // ?v=dlATMslQ6Uc
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s){
        HashMap<Character, Integer> hashMap = new HashMap<>();
        hashMap.put('I', 1);
        hashMap.put('V', 5);
        hashMap.put('X', 10);
        hashMap.put('L', 50);
        hashMap.put('C', 100);
        hashMap.put('D', 500);
        hashMap.put('M', 1000);

        int mynum = hashMap.get(s.charAt(s.length()-1));

        for (int i = s.length()-2; i >= 0; i--) {
            Integer left = hashMap.get(s.charAt(i));
            Integer right = hashMap.get(s.charAt(i+1));
            if(left < right) {
                mynum -= hashMap.get(s.charAt(i));
            }
            else {
                mynum += hashMap.get(s.charAt(i));
            }
        }

        return mynum;
    }
}
