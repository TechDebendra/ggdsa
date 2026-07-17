package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _15InfixToPostFix {
    public static void main(String[] args) {
        String infix = "a+b/c-d*e";
        System.out.println("Infix : "+infix);;
        System.out.println("Postfix : "+infixToPostfix(infix));

        String infix1 = "(a+b)*c";
        System.out.println("Infix1 : "+infix1);;
        System.out.println("Postfix1 : "+infixToPostfix(infix1));

        String infix2 = "a+b*c";
        System.out.println("infix2 : "+infix2);;
        System.out.println("Postfix2 : "+infixToPostfix(infix2));

        String infix3 = "a+b*(c^d-e)^(f+g*h)-i";
        System.out.println("infix3 : "+infix3);;
        System.out.println("Postfix3 : "+infixToPostfix(infix3));
    }

    public static String infixToPostfix(String string){
        if ( string == null || string.isEmpty()){
            throw new IllegalArgumentException("Invalid input");
        }
        StringBuilder result = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        for (char ch : string.toCharArray()){
            if (Character.isLetterOrDigit(ch)){
                result.append(ch);
            } else if ((ch == '(')) {
                stack.push(ch);
            } else if ( ch == ')') {
                while (!stack.isEmpty() && '(' != stack.peek()) {
                    result.append(stack.pop());
                }
                if (stack.isEmpty()) {  // here stack cannot be empty as it should have ( char
                    throw new IllegalArgumentException("Invalid Expression");
                }
                stack.pop();
            } else {
                while (!stack.isEmpty()
                        && '(' != stack.peek()
                        && (
                                precedence(ch) < precedence(stack.peek()) ||
                                (precedence(ch) == precedence(stack.peek()) && stack.peek()!='^')
                        ) ){
                    result.append(stack.pop());
                }
                stack.push(ch);
            }
        }

        while (!stack.isEmpty()){
            if (stack.peek() == '(') {
                throw new IllegalArgumentException("Invalid Expression");
            }
            result.append(stack.pop());
        }


        return result.toString();
    }

    public static int precedence(char ch){
        return switch (ch) {
            case '+', '-' -> 1;
            case '*', '/' -> 2;
            case '^' -> 3;
            default -> -1;
        };
    }
}
