package solutions.easy;

import java.util.Stack;

public class ValidParentheses3 {
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
        Stack<Character> stc = new Stack<>();
        char[] chars = s.toCharArray();
        for (char c : chars) {
            switch (c) {
                case '(':
                case '{':
                case '[':
                    stc.push(c);
                    break;
                case ')':
                    if (stc.isEmpty() || stc.pop() != '(') return false; break;
                case '}':
                    if (stc.isEmpty() || stc.pop() != '{') return false; break;
                case ']':
                    if (stc.isEmpty() || stc.pop() != '[') return false; break;
            }
        }

        return stc.isEmpty();
    }
}
