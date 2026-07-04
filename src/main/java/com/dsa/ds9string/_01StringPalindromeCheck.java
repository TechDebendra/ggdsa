package com.dsa.ds9string;

public class _01StringPalindromeCheck {
    public static void main(String[] args) {
        System.out.println("abcde is palindrome :"+isPalindrome("abcde"));
        System.out.println("abcba is palindrome :"+isPalindrome("abcba"));

    }

    public static boolean isPalindrome(String string){
        if (string==null){
            return false;
        }
        int start=0;
        int end=string.length()-1;

        while (start<=end){
            if (string.charAt(start)!=string.charAt(end)){
                return false;
            }
            start++;
            end--;
        }


        return true;
    }
}
