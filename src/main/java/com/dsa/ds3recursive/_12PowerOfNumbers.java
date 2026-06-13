package com.dsa.ds3recursive;

/*
* Given a number n, find the value of n raised to the power of its own reverse.
Note: The result will always fit into a 32-bit signed integer.

Examples:

Input: n = 2
Output: 4
Explanation: The reverse of 2 is 2, and 22 = 4.
Input: n = 10
Output: 10
Explanation: The reverse of 10 is 1 (leading zero is discarded), and 10 raised to the power 1 is 10.
* */

public class _12PowerOfNumbers {
    public static void main(String[] args) {
        System.out.println(reverseExponentiation(2));
        System.out.println(reverseExponentiation(10));
        System.out.println(reverseExponentiation(100));
        System.out.println(reverseExponentiation(11));

    }

    public static int reverseExponentiation(int n){
        int rev=reverse(n,0);
        return power(n,rev);
    }

    public static int power(int base, int exp){
        if (exp==0){
            return 1;
        }
        return base*power(base,exp-1);
    }

    public static int reverse(int num, int rev){
        if(num == 0){
            return rev;
        }
        return reverse(num/10,rev*10+num%10);
    }
}
