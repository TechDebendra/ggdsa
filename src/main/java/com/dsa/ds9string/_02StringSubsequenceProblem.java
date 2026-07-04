package com.dsa.ds9string;

public class _02StringSubsequenceProblem {
    public static void main(String[] args) {
        System.out.println(isSubsequence("ABCDE", "ACE"));      // true
        System.out.println(isSubsequence("ABCDE", "AEC"));      // false
        System.out.println(isSubsequence("ABCDE", "ABCDE"));    // true
        System.out.println(isSubsequence("ABCDE", ""));         // true
        System.out.println(isSubsequence("", ""));              // true
        System.out.println(isSubsequence("", "A"));             // false
        System.out.println(isSubsequence("ABC", "ABCD"));       // false
        System.out.println(isSubsequence("AABBCC", "ABC"));     // true
        System.out.println(isSubsequence("ABCD", "D"));         // true
        System.out.println(isSubsequence("ABCD", "E"));         // false

        String str1 = "ABCDE";
        String str2= "ACE";
        System.out.println(isSubsequence2(str1,str2,str1.length(),str2.length()));

    }

    public static boolean isSubsequence(String str1, String str2){
        if (str1 == null || str2 == null){
            return false;
        }

        int n = str1.length();
        int m = str2.length();

        if (n<m){
            return false;
        }
        int i=0,j=0;

        while (i<n && j< m){
             if (str1.charAt(i) == str2.charAt(j)){
                 i++;
                 j++;
             }else {
                 i++;
             }
        }

        return j==m;
    }

    public static boolean isSubsequence2(String str1, String str2, int n1, int n2){

        if (n2==0){
            return true;
        }

        if (n1==0){
            return false;
        }

        if (str1.charAt(n1-1) == str2.charAt(n2-1)){
            return isSubsequence2(str1,str2,n1-1,n2-1);
        }else {
            return isSubsequence2(str1,str2,n1-1,n2);
        }

    }
}
