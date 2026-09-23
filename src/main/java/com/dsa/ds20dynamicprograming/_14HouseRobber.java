package com.dsa.ds20dynamicprograming;

public class _14HouseRobber {
    public static int maxLoot(int[] houses, int n){
        if (n == 1){
            return houses[0];
        }
        if (n == 2){
            return Math.max(houses[0], houses[1]);
        }

        return Math.max(
                houses[n-1] + maxLoot(houses,n-2),
                maxLoot(houses,n-1)
        );
    }

    public static void main(String[] args) {
        int[] arr = {10, 20, 30, 40};
        System.out.println(maxLoot(arr, arr.length));

        System.out.println("DP Result : "+maxLootDP(arr,arr.length));
    }


    public static int maxLootDP(int[] houses, int n){
        int[] dp = new int[n];

        dp[0] = houses[0];
        dp[1] = Math.max(houses[0], houses[1]);

        for (int i =2 ; i < n ; i++){
            dp[i] = Math.max(
                    dp[i-1],
                    dp[i-2] + houses[i]
            );
        }
        return dp[n-1];
    }

    public static int maxLootSpaceOptimised(int[] houses, int n) {

        int prev2 = houses[0];
        int prev1 = Math.max(houses[0], houses[1]);

        for (int i = 2; i < n; i++) {

            int curr = Math.max(
                    prev1,
                    prev2 + houses[i]
            );

            prev2 = prev1;
            prev1 = curr;
        }

        return prev1;
    }

    public static int robDP(int[] houses, int start, int end) {

        int n = end - start + 1;

        if (n == 1)
            return houses[start];

        int[] dp = new int[n];

        dp[0] = houses[start];
        dp[1] = Math.max(houses[start], houses[start + 1]);

        for (int i = 2; i < n; i++) {

            dp[i] = Math.max(
                    dp[i - 1],
                    dp[i - 2] + houses[start + i]
            );
        }

        return dp[n - 1];
    }

    public static int maxLootCircular(int[] houses) {

        int n = houses.length;

        if (n == 1)
            return houses[0];

        return Math.max(
                robDP(houses, 0, n - 2),
                robDP(houses, 1, n - 1)
        );
    }

}
