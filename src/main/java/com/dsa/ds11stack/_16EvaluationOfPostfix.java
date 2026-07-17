package com.dsa.ds11stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class _16EvaluationOfPostfix {
    public static void main(String[] args) {
        String exp = "100 200 + 2 / 5 * 7 +";
        System.out.println("postfix evaluation: "+evaluationPostfix(exp));
    }

    public static int evaluationPostfix(String exp){
        if (exp == null || exp.isEmpty()){
            throw new IllegalArgumentException("Invalid Input");
        }

        Deque<Integer> stack = new ArrayDeque<>();

        for (int i=0;i<exp.length();i++){
            char ch = exp.charAt(i);

            if (ch == ' '){
                continue;
            }else if (Character.isDigit(ch)){
                int n=0;
                while (i < exp.length() && Character.isDigit(exp.charAt(i))){
                    n = n*10 + (int)(exp.charAt(i) - '0');
                    i++;
                }
                i--;
                stack.push(n);
            }else {
                if (stack.size() < 2){
                    throw new IllegalArgumentException("Invalid postfix expression");
                }


                int val1 = stack.pop();
                int val2 = stack.pop();

                switch (ch){
                    case '+':
                        stack.push(val2+val1);
                        break;
                    case '-':
                        stack.push(val2-val1);
                        break;
                    case '*':
                        stack.push(val2*val1);
                        break;
                    case '/':
                        stack.push(val2/val1);
                        break;
                    case '^':
                        stack.push((int) Math.pow(val2,val1));
                        break;
                    default:
                        throw new IllegalStateException("Invalid operator!");
                }

            }
        }

        if (stack.size() != 1){
            throw new IllegalArgumentException("Invalid postfix expression");
        }

        return stack.pop();

    }
}
