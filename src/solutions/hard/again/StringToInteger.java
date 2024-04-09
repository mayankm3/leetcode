package solutions.hard.again;

public class StringToInteger {

	public static void main(String[] args) {
		// https://leetcode.com/problems/string-to-integer-atoi/
		
		
		int i=45,j=-5;
		System.out.println(i+j);
		
		int a = 5-'0';	//5-48=-43
		System.out.println(a);
		
		String s = "+4193";		
		int someVar=Integer.parseInt(s);
		System.out.println(someVar);

        StringToInteger stoi = new StringToInteger();
        int abc = stoi.myAtoi("53");
        System.out.println(abc);
		
		
	}
	
	public int myAtoi(String str) {
        if(str.length() == 0) return 0;
        
        int index = 0,total = 0,sign = 1;
        
        // remove white spaces from the string
        while(index < str.length() && str.charAt(index) == ' ')
            index++;
        
        if (index == str.length()) return 0;
        
        // get the sign
        if(str.charAt(index) == '+' || str.charAt(index) == '-') {
            sign = str.charAt(index) == '+' ? 1 : -1;
            index++;
        }
        
        // convert to the actual number and make sure it's not overflow
        while(index < str.length()) {
            int digit = str.charAt(index) - '0';
            if(digit < 0 || digit > 9) break;
            
            // check for overflow
            //Integer.MAX_VALUE=2147483647 and Integer.MAX_VALUE=2147483647/10=214748364
            if(total > Integer.MAX_VALUE / 10 || (total == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10))
                return sign == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            
            total = total*10 + digit;
            index++; // don't forget to increment the counter
        }
        return total*sign;
    }

}
