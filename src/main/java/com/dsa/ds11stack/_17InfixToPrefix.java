package com.dsa.ds11stack;

import java.util.Stack;

public class _17InfixToPrefix {

    public static void main(String[] args) {
        String s = ("x+y*z/w+u");
        System.out.print(infixToPrefix(s));
    }

    public static String infixToPrefix(String exp){
        if (exp == null || exp.isEmpty()){
            throw new IllegalArgumentException("Invalid Input!");
        }
        StringBuilder result = new StringBuilder();
        Stack<Character> stack = new Stack<>();
        exp = reverse(exp);
        for (int i = 0 ; i < exp.length() ; i++){
            char ch = exp.charAt(i);

            if (Character.isLetterOrDigit(ch)){
                result.append(ch);
            } else if (ch == '('){
                stack.push(ch);
            } else if (')' == ch) {
                while (!stack.isEmpty() && '(' != stack.peek()){
                    result.append(stack.pop());
                }
                if (stack.isEmpty()){
                    throw new IllegalArgumentException("invalid Expression");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() &&
                        '(' !=stack.peek() &&
                        (
                            precedence(ch) < precedence(stack.peek()) ||
                            (precedence(ch) == precedence(stack.peek()) && ch == '^')
                        )){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }

        }

        while (!stack.isEmpty()){
            if (stack.peek() == '('){
                throw new IllegalArgumentException("invalid Expression");
            }
            result.append(stack.pop());
        }

        return result.reverse().toString();
    }

    public static int precedence(char ch){
        return switch (ch){
            case '+', '-' -> 1;
            case '*','/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }

    public static String reverse(String exp){
        exp = new StringBuilder(exp).reverse().toString();

        char[] chars = exp.toCharArray();
        for (int i=0 ; i< exp.length() ;i++){
            chars[i] = reverseParenthesis(chars[i]);
        }

        return String.valueOf(chars);
    }

    public static char reverseParenthesis(char ch){
        return switch (ch) {
            case '(' -> ')';
            case ')' -> '(';
            default -> ch;
        };
    }
}
