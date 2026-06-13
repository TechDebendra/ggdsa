package com.dsa.ds3recursive;
/*
*A lucky number is defined using a special elimination process:
   1. Start with natural numbers: 1, 2, 3, 4, 5, 6, ...
   2. In the 1st step, remove every 2nd number.
   3. In the 2nd step, remove every 3rd remaining number.
   4. In the 3rd step, remove every 4th remaining number, and so on...
This continues indefinitely. Given an integer n, determine if it remains after all steps.
Return 1 if n is a lucky number, otherwise return 0.

Examples :

Input: n = 5
Output: 0
Explanation: 5 is not a lucky number as it gets deleted in the second iteration.
Input: n = 19
Output: 1
Explanation: 19 is a lucky number because it does not get deleted throughout the process.
* */
public class _15LuckyNumber {
    public static void main(String[] args) {
        System.out.println("5 is lucky number :"+isLucky(5,2));
        System.out.println("19 is lucky number :"+isLucky(19,2));
    }

    public static boolean isLucky(int n, int c){
        if(c>n) return  true;
        if(n%c==0) return false;
        n=n-(n/c);
        c++;
        return isLucky(n,c);

    }
}
