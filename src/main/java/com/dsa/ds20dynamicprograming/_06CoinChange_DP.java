package com.dsa.ds20dynamicprograming;

public class _06CoinChange_DP {

    public static int coinChange(int[] coins, int sun, int n){
        int[] table = new int[sun+1];
        table[0] = 1;

        for (int i = 0 ; i < n ; i++){
            for (int j = coins[i] ; j <= sun ; j++ ){
                if (j - coins[i] >= 0){
                    table[j] += table[j-coins[i]];
                }
            }
        }

        return table[sun];
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
        int n = coins.length;
        int sum = 4;
        System.out.println(coinChange(coins, sum, n));
    }




}
