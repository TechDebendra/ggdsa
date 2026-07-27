package com.dsa.ds9string;

import java.util.ArrayDeque;
import java.util.Deque;

public class _09CheckIfStringsAreRotations {
    public static void main(String[] args) {
        System.out.println(areRotations("ABCD","CDAB"));  ;    // true
        System.out.println(areRotations("ABCD","ABCD"));      // true
        System.out.println(areRotations("AAAA","AAAA"));      // true
        System.out.println(areRotations("ABCD","ACBD"));      // false
        System.out.println(areRotations("ABCD","ABC"));       // false

    }

    public static boolean areRotations(String str1, String str2){
        if (str1 ==null || str2 == null || str1.isEmpty() || str2.isEmpty()){
            throw new IllegalArgumentException("Invalid Input!");
        }
        return (str1.length() == str2.length()) && ((str1 + str1).contains(str2));
    }

    public static boolean areRotations2(String str1, String str2) {

        if (str1.length() != str2.length()) {
            return false;
        }

        Deque<Character> q1 = new ArrayDeque<>();
        Deque<Character> q2 = new ArrayDeque<>();

        for (char ch : str1.toCharArray()) {
            q1.addLast(ch);
        }

        for (char ch : str2.toCharArray()) {
            q2.addLast(ch);
        }

        if (q1.equals(q2)) {
            return true;
        }

        for (int i = 0; i < str2.length(); i++) {
            q2.addLast(q2.pollFirst());

            if (q1.equals(q2)) {
                return true;
            }
        }

        return false;
    }


}
