package com.dsa.ds3recursive;
/*
*
* You are given a number n. You need to find the digital root of n. Digital Root of a number is the recursive sum of its digits until we get a single digit number.

Examples :

Input: n = 1
Output:  1
Explanation: Digital root of 1 is 1
Input: n = 99999
Output: 9
Explanation: Sum of digits of 99999 is 45 which is not a single digit number, hence sum of digit of 45 is 9 which is a single digit number.
* */
public class _14DigitalRoot {
    public static void main(String[] args) {
        System.out.println("Digital sum of 12345 :"+digitalSum(12345));

    }

    public static int digitalSum(int n){
        if (n<10)return n;
        return digitalSum(sum(n));
    }

    public static int sum(int n){
        if (n<10)return n;
        return n%10+sum(n/10);
    }
}
