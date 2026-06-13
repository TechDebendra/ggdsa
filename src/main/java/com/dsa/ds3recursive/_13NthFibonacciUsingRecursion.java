package com.dsa.ds3recursive;

public class _13NthFibonacciUsingRecursion {
    public static void main(String[] args) {
        System.out.println("3rd fibonacci is "+nthFibonacci(3));
        System.out.println("5th fibonacci is "+nthFibonacci(5));
        System.out.println("0th fibonacci is "+nthFibonacci(0));

    }

    public static int nthFibonacci(int n){
        if(n==0 || n==1){
            return n;
        }

        return nthFibonacci(n-1)+nthFibonacci(n-2);
    }
}
