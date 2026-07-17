package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _18EvaluationOfPrefix {
    public static void main(String[] args) {
        String exprsn = "+ 9 * 12 6";
        System.out.print((int)evaluatePrefix(exprsn));
    }

    public static int evaluatePrefix(String exp){
        if (exp == null || exp.isEmpty()){
            throw new IllegalArgumentException("Invalid Input");
        }
        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=exp.length()-1;i>=0;i--){
            char ch = exp.charAt(i);

            if (ch == ' '){
                continue;
            }else if (Character.isDigit(exp.charAt(i))){
                int n = 0;
                int multiplier = 1;

                while (i >= 0 && Character.isDigit(exp.charAt(i))) {
                    n += (exp.charAt(i) - '0') * multiplier;
                    multiplier *= 10;
                    i--;
                }
                i++;

                stack.push(n);
            }else {
                if (stack.size()<2){
                    throw new IllegalArgumentException("Invalid Input!");
                }

                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (ch) {
                    case '+':
                        stack.push(val1 + val2);
                        break;

                    case '-':
                        stack.push(val1 - val2);
                        break;

                    case '*':
                        stack.push(val1 * val2);
                        break;

                    case '/':
                        if (val2 == 0)
                            throw new ArithmeticException("Division by zero");
                        stack.push(val1 / val2);
                        break;

                    case '^':
                        stack.push((int) Math.pow(val1, val2));
                        break;

                    default:
                        throw new IllegalArgumentException("Invalid operator: " + ch);
                }

            }

        }

        if (stack.size() != 1) {
            throw new IllegalArgumentException("Invalid Prefix Expression");
        }

        return stack.pop();
    }
}
