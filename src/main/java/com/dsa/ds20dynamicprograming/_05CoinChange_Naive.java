package com.dsa.ds20dynamicprograming;

public class _05CoinChange_Naive {

    public static int countWays(int[] coins, int n, int sum){
        if (sum == 0){
            return 1;
        } else if (sum < 0) {
            return 0;
        } else if (n == 0) {
            return 0;
        }

        return countWays(coins,n,sum-coins[n-1])
                + countWays(coins,n-1,sum);
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 3 };
        int n = coins.length;

        System.out.println(countWays(coins, n, 4));
    }
}
