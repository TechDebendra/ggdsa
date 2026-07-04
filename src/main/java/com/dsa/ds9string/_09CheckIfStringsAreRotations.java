package com.dsa.ds9string;

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
}
