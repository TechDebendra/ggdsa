package com.dsa.ds20dynamicprograming;

import java.util.Arrays;

public class _12MinimumJumps {

    public static int getMinimumJumps(int[] arr, int n){
        if (n == 1){
            return 0;
        }
        int result = Integer.MAX_VALUE;

        for (int i =0; i <= n - 2; i++){
            if (i + arr[i] >= n-1){
                int subResult = getMinimumJumps(arr,i+1);
                if (subResult != Integer.MAX_VALUE){
                    result = Math.min( result, subResult +1);
                }
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int[] arr = {3,4,2,1,2,1};

        int res = getMinimumJumps(arr, arr.length);

        System.out.println("Result : "+res);

        int resDP = getMinimumUsingDP(arr, arr.length);

        System.out.println("DP Result : "+resDP);
    }

    // Dynamic programming

    public static int getMinimumUsingDP(int[] arr, int n){
        int[] dp = new int[n];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1 ; i < n ; i++){
            for (int j =0; j < i ; j++){
                if (j + arr[j] >= i){
                    if (dp[j] != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],dp[j]+1);
                    }
                }
            }
        }

        return dp[n-1];
    }

}
