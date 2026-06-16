package com.dsa.ds4array;

/**
 * Stock Buy and Sell Problem (Multiple Transactions Allowed).
 *
 * <p>Given an array of stock prices where arr[i] represents the price
 * of a stock on day i, find the maximum profit that can be earned by
 * making multiple buy-sell transactions.
 *
 * <p>This implementation uses a recursive brute-force approach that
 * tries every possible buy and sell combination.
 *
 * <p>Example:
 * <pre>
 * Input : [1, 5, 3, 8, 12]
 * Output: 13
 *
 * Explanation:
 * Buy at 1, Sell at 5  => Profit = 4
 * Buy at 3, Sell at 12 => Profit = 9
 * Total Profit = 13
 * </pre>
 *
 * <p>Time Complexity: Exponential (approximately O(2^n))
 * <br>Space Complexity: O(n) due to recursion stack
 */
public class _18StockBuyAndSellProblem {

    public static void main(String[] args) {

        int[] arr1 = {1, 5, 3, 8, 12};
        System.out.println("Test 1: " +
                maxProfit(arr1, 0, arr1.length - 1));
        // Expected: 13

        int[] arr2 = {30, 20, 10};
        System.out.println("Test 2: " +
                maxProfit(arr2, 0, arr2.length - 1));
        // Expected: 0

        int[] arr3 = {10, 20, 30};
        System.out.println("Test 3: " +
                maxProfit(arr3, 0, arr3.length - 1));
        // Expected: 20

        int[] arr4 = {1, 5};
        System.out.println("Test 4: " +
                maxProfit(arr4, 0, arr4.length - 1));
        // Expected: 4

        int[] arr5 = {100};
        System.out.println("Test 5: " +
                maxProfit(arr5, 0, arr5.length - 1));
        // Expected: 0

        int[] arr6 = {1, 3, 1, 2, 5};
        System.out.println("Test 6: " +
                maxProfit(arr6, 0, arr6.length - 1));
        // Expected: 6
        // (1->3 = 2) + (1->5 = 4)

        int[] arr7 = {5, 5, 5, 5};
        System.out.println("Test 7: " +
                maxProfit(arr7, 0, arr7.length - 1));
        // Expected: 0
    }

    /**
     * Returns the maximum profit obtainable from the subarray
     * arr[start...end] by performing multiple buy-sell transactions.
     *
     * <p>For every possible pair of buy day (i) and sell day (j),
     * where arr[j] > arr[i], the method calculates:
     *
     * <pre>
     * profit =
     *     (sellPrice - buyPrice)
     *     + profit before buying
     *     + profit after selling
     * </pre>
     *
     * and returns the maximum profit among all such possibilities.
     *
     * @param arr   array of stock prices
     * @param start starting index of the current range
     * @param end   ending index of the current range
     * @return maximum profit obtainable in the range [start, end]
     */
    public static int maxProfit(int[] arr, int start, int end) {

        if (start > end) {
            return 0;
        }

        int profit = 0;

        for (int i = start; i < end; i++) {

            for (int j = i + 1; j <= end; j++) {

                if (arr[j] > arr[i]) {

                    int currentProfit =
                            arr[j] - arr[i]
                                    + maxProfit(arr, start, i - 1)
                                    + maxProfit(arr, j + 1, end);

                    profit = Math.max(currentProfit, profit);
                }
            }
        }

        return profit;
    }
}