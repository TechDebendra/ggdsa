package com.dsa.ds20dynamicprograming;

public class _08EditDistance_DP {

    public static int editDist(String s1, String s2, int m, int n){
        int[][] dp = new int[m+1][n+1];

        for (int i = 0 ; i <=m ; i ++){
            dp[i][0] = i;
        }

        for (int j = 0 ; j <=n ; j++){
            dp[0][j]=j;
        }

        for (int i = 1 ; i <=m ;i++){
            for (int j =1 ; j <=n ; j++){
                if (s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1];
                }else {
                    dp[i][j] = 1 + Math.min(
                            Math.min(
                                    dp[i][j-1],
                                    dp[i-1][j]
                            )
                            ,
                            dp[i-1][j-1]
                    );
                }
            }
        }

        return dp[m][n];
    }

    public static void main(String[] args) {
        String str1 = "sunday";
        String str2 = "saturday";

        System.out.println(editDist(
                str1, str2, str1.length(), str2.length()));
    }
}
