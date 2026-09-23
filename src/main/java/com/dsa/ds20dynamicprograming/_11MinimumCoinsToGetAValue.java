package com.dsa.ds20dynamicprograming;

import java.util.Arrays;

public class _11MinimumCoinsToGetAValue {

    public static int getMinimum(int[] coins, int value){
        int[] dp = new int[value+1];

        Arrays.fill(dp,Integer.MAX_VALUE);

        dp[0] = 0;


        for (int i =1 ; i <=value;i++){
            for (int j = 0 ; j < coins.length; j++){
                if (coins[j] <=i ){
                    int subResult = dp[i-coins[j]];

                    if (subResult != Integer.MAX_VALUE){
                        dp[i] = Math.min(dp[i],subResult + 1);
                    }
                }
            }
        }

        return dp[value];
    }

    public static void main(String[] args) {
        int[] coins = {3,4,1};
        int val = 5;

        int res = getMinimum(coins,val);

        System.out.println("Result : "+res);
    }
}
