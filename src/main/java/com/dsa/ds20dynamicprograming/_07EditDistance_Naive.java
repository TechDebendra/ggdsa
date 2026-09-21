package com.dsa.ds20dynamicprograming;

public class _07EditDistance_Naive {

    public static int editDistance(String s1, String s2, int m, int n){
        if (m == 0){
            return n;
        }
        if (n == 0 ){
            return m;
        }

        if (s1.charAt(m-1) == s2.charAt(n-1)){
            return editDistance(s1,s2,m-1,n-1);
        }
        return 1 + Math.min(
                Math.min(
                        editDistance(s1,s2,m,n-1),
                        editDistance(s1,s2,m-1,n)
                )
                ,
                editDistance(s1,s2,m-1,n-1)
        );
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDistance(
                str1, str2, str1.length(), str2.length()));
    }
}
