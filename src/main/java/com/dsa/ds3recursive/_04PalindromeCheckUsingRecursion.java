package com.dsa.ds3recursive;

/**
 * Program to check whether a given string is a palindrome using recursion.
 *
 * A palindrome is a word, phrase, number, or sequence of characters
 * that reads the same forward and backward.
 *
 * Examples:
 * madam   -> true
 * racecar -> true
 * abcb    -> false
 * abcba   -> true
 * hello   -> false
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n) due to recursive call stack
 *
 * @author Debendra
 */
public class _04PalindromeCheckUsingRecursion {

    public static void main(String[] args) {

        String str1 = "abcb";
        String str2 = "abcba";
        String str3 = "madam";
        String str4 = "racecar";
        String str5 = "hello";
        String str6 = "a";
        String str7 = "";

        System.out.println(str1 + " is palindrome : "
                + isPalindrome(str1, 0, str1.length() - 1));

        System.out.println(str2 + " is palindrome : "
                + isPalindrome(str2, 0, str2.length() - 1));

        System.out.println(str3 + " is palindrome : "
                + isPalindrome(str3, 0, str3.length() - 1));

        System.out.println(str4 + " is palindrome : "
                + isPalindrome(str4, 0, str4.length() - 1));

        System.out.println(str5 + " is palindrome : "
                + isPalindrome(str5, 0, str5.length() - 1));

        System.out.println(str6 + " is palindrome : "
                + isPalindrome(str6, 0, str6.length() - 1));

        System.out.println("\"" + str7 + "\"" + " is palindrome : "
                + isPalindrome(str7, 0, str7.length() - 1));
    }

    /**
     * Recursively checks whether a string is a palindrome.
     *
     * Algorithm:
     * 1. Compare the first and last characters.
     * 2. If they are different, return false.
     * 3. If they are same, recursively check the remaining substring.
     * 4. Stop when start index crosses end index.
     *
     * Example:
     * String = "abcba"
     *
     * Call 1: a == a -> check "bcb"
     * Call 2: b == b -> check "c"
     * Call 3: start >= end -> true
     *
     * @param string Input string to be checked.
     * @param start  Starting index.
     * @param end    Ending index.
     * @return true if string is palindrome, otherwise false.
     */
    public static boolean isPalindrome(String string, int start, int end) {

        // Base condition:
        // If start meets or crosses end, all characters matched.
        if (start >= end) {
            return true;
        }

        // Compare current characters and recursively check remaining string.
        return string.charAt(start) == string.charAt(end)
                && isPalindrome(string, start + 1, end - 1);
    }
}