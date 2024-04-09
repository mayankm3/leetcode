package solutions.easy;

import java.util.Stack;

public class ValidParentheses1 {
    // Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    // "(]" and "([)]" are not valid
    // ([]{}) is valid too
    // [()]{} is valid
    public static void main(String[] args) {
        System.out.println(isValid("()"));
        System.out.println(isValid("()[]{}"));  // 40 41 91 93 123 125
        System.out.println(isValid("(]"));
        System.out.println(isValid("([)]"));
        System.out.println(isValid("["));
        System.out.println(isValid("([]{})"));
        System.out.println(isValid("[()]{}"));
    }

    public static boolean isValid(String s) {

        char[] charr = s.toCharArray();
        Stack<Character> stc = new Stack<>();

        for (int i = 0; i < charr.length; i++) {
            if(charr[i] == '(' || charr[i] == '[' || charr[i] == '{') {
                stc.push(charr[i]);
            }
            else{
                if (stc.empty()) return false;
                Character popped = stc.pop();
                if (charr[i] == ')') {
                    if ( !popped.equals('(')) return false;
                }
                else if (charr[i] == '}') {
                    if ( !popped.equals('{')) return false;
                }
                else if (charr[i] == ']') {
                    if ( !popped.equals('[')) return false;
                }
            }

        }

        return stc.empty();
    }
}
