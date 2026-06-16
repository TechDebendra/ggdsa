package com.dsa.ds4array;

/**
 * Trapping Rain Water - Dynamic Programming Solution.
 *
 * <p>Given an array of non-negative integers representing the height
 * of bars, calculate the total amount of rainwater that can be trapped.
 *
 * <p>The idea is to precompute:
 * <ul>
 *     <li>leftMax[i] = maximum height from index 0 to i</li>
 *     <li>rightMax[i] = maximum height from index i to n - 1</li>
 * </ul>
 *
 * For each bar:
 *
 * <pre>
 * waterAtI = min(leftMax[i], rightMax[i]) - arr[i]
 * </pre>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(n)
 */
public class _21TrappingRainWater_Case2 {

    public static void main(String[] args) {

        int[] arr1 = {3, 0, 1, 2, 5};
        System.out.println("Test 1: " + waterCapacity(arr1));
        // Expected: 6

        int[] arr2 = {2, 0, 2};
        System.out.println("Test 2: " + waterCapacity(arr2));
        // Expected: 2

        int[] arr3 = {3, 0, 2, 0, 4};
        System.out.println("Test 3: " + waterCapacity(arr3));
        // Expected: 7

        int[] arr4 = {1, 2, 3, 4, 5};
        System.out.println("Test 4: " + waterCapacity(arr4));
        // Expected: 0

        int[] arr5 = {5, 4, 3, 2, 1};
        System.out.println("Test 5: " + waterCapacity(arr5));
        // Expected: 0

        int[] arr6 = {4, 2, 0, 3, 2, 5};
        System.out.println("Test 6: " + waterCapacity(arr6));
        // Expected: 9

        int[] arr7 = {5};
        System.out.println("Test 7: " + waterCapacity(arr7));
        // Expected: 0

        int[] arr8 = {};
        System.out.println("Test 8: " + waterCapacity(arr8));
        // Expected: 0
    }

    /**
     * Calculates the total amount of trapped rainwater.
     *
     * @param arr array representing bar heights
     * @return total units of trapped water
     */
    public static int waterCapacity(int[] arr) {

        if (arr == null || arr.length < 3) {
            return 0;
        }

        int n = arr.length;
        int result = 0;

        int[] leftMaxArray = new int[n];
        int[] rightMaxArray = new int[n];

        leftMaxArray[0] = arr[0];

        for (int i = 1; i < n; i++) {
            leftMaxArray[i] = Math.max(arr[i], leftMaxArray[i - 1]);
        }

        rightMaxArray[n - 1] = arr[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rightMaxArray[i] = Math.max(arr[i], rightMaxArray[i + 1]);
        }

        for (int i = 1; i < n - 1; i++) {
            result += Math.min(leftMaxArray[i], rightMaxArray[i]) - arr[i];
        }

        return result;
    }
}