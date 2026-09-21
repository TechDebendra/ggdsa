package com.dsa.ds20dynamicprograming;

public class _03LongestCommonSubsequence_Naive {

    public static int lcs(String s1, String s2,int m, int n){
        if (m == 0 || n == 0){
            return 0;
        }
        if (s1.charAt(m-1) == s2.charAt(n-1)){
            return 1 + lcs(s1,s2,m-1,n-1);
        }

        return Math.max(lcs(s1,s2,m,n-1),lcs(s1,s2,m-1,n));
    }

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ADCFH";
        int result = lcs(s1,s2,s1.length(),s2.length());
        System.out.println("Result : "+result);
    }
}
