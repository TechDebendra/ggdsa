package com.dsa.math;

public class _03FactorialOfNum {
    public static void main(String[] args) {
        System.out.println("Iterative Approach.");
        System.out.println("Factorial of 5 :"+iterativeFactorial(5));
        System.out.println("Factorial of 6 :"+iterativeFactorial(6));

        System.out.println("Recursive Approach.");
        System.out.println("Factorial of 5 :"+recursiveFactorial(5));
        System.out.println("Factorial of 6 :"+recursiveFactorial(6));

    }

    //Iterative Approach.
    // Time complexity: O(n)
    // Space complexity: O(1)
    public static int iterativeFactorial(int num){
        int res=1;
        for(int i=2;i<=num;i++){
            res*=i;
        }
        return res;
    }

    //Recursive Approach.
    // Time complexity: O(n)
    // Space complexity: O(n) due to recursion stack
    public static int recursiveFactorial(int num){
        if(num==0||num==1){
            return 1;
        }
        return num*recursiveFactorial(num-1);
    }



}
