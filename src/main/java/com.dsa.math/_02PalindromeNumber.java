package com.dsa.math;
/*
* Time Complexity: O(log n)
* Space Complexity: O(1)
* */
public class _02PalindromeNumber {
    public static void main(String[] args) {
        System.out.println("1232 is palindrome :"+isPalindrome(1232));
        System.out.println("12321 is palindrome :"+isPalindrome(12321));
        System.out.println("-45654 is palindrome :"+isPalindrome(-45654));

    }
    public static boolean isPalindrome(int num){
        if(num<0){
            num=num*-1;
        }
        int rev=0,temp=num;
        while (temp>0){
            int rem=temp%10;
            rev=rev*10+rem;
            temp/=10;
        }
        return rev == num;
    }
}
