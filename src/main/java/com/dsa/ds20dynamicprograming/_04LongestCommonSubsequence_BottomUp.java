package com.dsa.ds20dynamicprograming;

public class _04LongestCommonSubsequence_BottomUp {

    public static void main(String[] args) {
        String s1 = "ABCD";
        String s2 = "ADCFH";

        int result = lcs(s1,s2);

        System.out.println("Result : "+result);

    }

    public static int lcs(String s1, String s2 ){

        int m = s1.length();
        int n = s2.length();

        int[][] table = new int[m + 1][n + 1];

        for (int i =0 ; i <=m ; i ++){
            table[i][0] = 0;
        }

        for (int j =0 ; j <=n ; j++){
            table[0][j] = 0;
        }

        for (int i = 1 ; i <=m ; i++){
            for (int j = 1; j <=n ; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    table[i][j] = 1 + table[i-1][j-1];
                }else {
                    table[i][j] = Math.max(
                            table[i][j-1],
                            table[i-1][j]
                    );
                }
            }
        }

        return table[m][n];
    }
}
