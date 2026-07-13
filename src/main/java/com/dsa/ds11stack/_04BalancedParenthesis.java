package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _04BalancedParenthesis {

    public static void main(String[] args) {
        String pattern1 = "({[]})";
        System.out.println(pattern1+" is valid :"+isValidParenthesis(pattern1));

        String pattern2 = "({[]}";
        System.out.println(pattern2+" is valid :"+isValidParenthesis(pattern2));
    }


    public static boolean isValidParenthesis(String pattern){
        Deque<Character> stack = new ArrayDeque<>();

        for (int i=0;i<pattern.length();i++){
            char ch = pattern.charAt(i);

            if (ch == '(' || ch == '{' || ch == '['){
                stack.push(ch);
            }else if (stack.isEmpty()){
                return false;
            }else if (!isMatching(ch,stack.pop())){
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static boolean isMatching(char ch, char top){
        return (ch == ')' && top == '(' )||
               (ch == '}' && top == '{' )||
               (ch == ']' && top == '[' );
    }
}
