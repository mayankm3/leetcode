package solutions.medium;

import java.util.Locale;
import java.util.Stack;

public class EvaluateReversePolishNotation {

    // Time: O(n)
    // Space: O(d), where d is no. of digits
    public static void main(String[] args) {
        String[] str0 = {"2","1","+","3","*"};
        System.out.println(evalRPN(str0));

        String[] str1 = {"4","13","5","/","+"};
        System.out.println(evalRPN(str1));

        String[] str2 = {"10","6","9","3","+","-11","*","/","*","17","+","5","+"};
        System.out.println(evalRPN(str2));
    }

    public static int evalRPN(String[] tokens) {
        Stack<Integer> stackOfInteger = new Stack<>();
        int firstPop, secondPop, operationResult;

        for (String token:tokens) {
            switch (token){
                case "+":
                    firstPop = stackOfInteger.pop();
                    secondPop = stackOfInteger.pop();
                    operationResult = secondPop+firstPop;
                    stackOfInteger.push(operationResult);
                    break;
                case "-":
                    firstPop = stackOfInteger.pop();
                    secondPop = stackOfInteger.pop();
                    operationResult = secondPop-firstPop;
                    stackOfInteger.push(operationResult);
                    break;
                case "/":
                    firstPop = stackOfInteger.pop();
                    secondPop = stackOfInteger.pop();
                    operationResult = secondPop/firstPop;
                    stackOfInteger.push(operationResult);
                    break;
                case "*":
                    firstPop = stackOfInteger.pop();
                    secondPop = stackOfInteger.pop();
                    operationResult = secondPop*firstPop;
                    stackOfInteger.push(operationResult);
                    break;
                default:
                    stackOfInteger.push(Integer.parseInt(token));
            }
        }

        return stackOfInteger.pop();
    }
}
