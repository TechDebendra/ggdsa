package com.dsa.ds4array;

/**
 * Stock Buy and Sell Problem (Efficient Solution).
 *
 * <p>Given an array of stock prices where arr[i] represents the stock
 * price on day i, find the maximum profit that can be earned by making
 * multiple buy-sell transactions.
 *
 * <p>Any number of transactions is allowed, but a stock must be sold
 * before buying again.
 *
 * <p>This greedy approach adds every positive price difference between
 * consecutive days.
 *
 * <pre>
 * Example:
 * Input : [1, 5, 3, 8, 12]
 *
 * Profit:
 * (5 - 1) + (8 - 3) + (12 - 8)
 * = 4 + 5 + 4
 * = 13
 * </pre>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _19StockBuyAndSellProblemEfficient {

    public static void main(String[] args) {

        int[] arr1 = {1, 5, 3, 8, 12};
        System.out.println("Test 1: " + profit(arr1));
        // Expected: 13

        int[] arr2 = {30, 20, 10};
        System.out.println("Test 2: " + profit(arr2));
        // Expected: 0

        int[] arr3 = {10, 20, 30};
        System.out.println("Test 3: " + profit(arr3));
        // Expected: 20

        int[] arr4 = {1, 5};
        System.out.println("Test 4: " + profit(arr4));
        // Expected: 4

        int[] arr5 = {100};
        System.out.println("Test 5: " + profit(arr5));
        // Expected: 0

        int[] arr6 = {1, 3, 1, 2, 5};
        System.out.println("Test 6: " + profit(arr6));
        // Expected: 6

        int[] arr7 = {5, 5, 5, 5};
        System.out.println("Test 7: " + profit(arr7));
        // Expected: 0

        int[] arr8 = {1, 2, 3, 4, 5};
        System.out.println("Test 8: " + profit(arr8));
        // Expected: 4
    }

    /**
     * Returns the maximum profit obtainable by performing
     * multiple buy-sell transactions.
     *
     * <p>The algorithm accumulates every positive difference
     * between consecutive days.
     *
     * @param arr array of stock prices
     * @return maximum profit
     */
    public static int profit(int[] arr) {

        int profit = 0;

        for (int i = 1; i < arr.length; i++) {

            if (arr[i] > arr[i - 1]) {
                profit += arr[i] - arr[i - 1];
            }
        }

        return profit;
    }
}