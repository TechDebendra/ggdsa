package com.dsa.ds4array;

/**
 * Finds the equilibrium index of an array.
 * An equilibrium index is an index where the sum of elements
 * on the left equals the sum of elements on the right.
 */
public class _04EquilibriumIndexOfArray {

    public static void main(String[] args) {

        // Test Case 1: No equilibrium index
        int[] arr1 = {9, 2, 5, 3, 6, 2};
        System.out.println(equilibriumIndex(arr1)); // -1

        // Test Case 2: Equilibrium in middle
        int[] arr2 = {3, 4, 8, -9, 20, 6};
        System.out.println(equilibriumIndex(arr2)); // 4

        // Test Case 3: Equilibrium at first index
        int[] arr3 = {4, 2, -2};
        System.out.println(equilibriumIndex(arr3)); // 0

        // Test Case 4: Single element array
        int[] arr4 = {5};
        System.out.println(equilibriumIndex(arr4)); // 0

        // Test Case 5: No equilibrium index
        int[] arr5 = {1, 2, 3, 4};
        System.out.println(equilibriumIndex(arr5)); // -1

        // Test Case 6: Equilibrium in middle
        int[] arr6 = {2, 3, -1, 8, 4};
        System.out.println(equilibriumIndex(arr6)); // 3

        // Test Case 7: All zeros
        int[] arr7 = {0, 0, 0, 0};
        System.out.println(equilibriumIndex(arr7)); // 0
    }

    /**
     * Returns the equilibrium index of the array.
     *
     * @param arr input array
     * @return equilibrium index, or -1 if none exists
     */
    public static int equilibriumIndex(int[] arr) {

        int leftSum = 0;
        int sum = 0;

        for (int num : arr) {
            sum += num;
        }

        for (int i = 0; i < arr.length; i++) {

            sum -= arr[i]; // right sum

            if (leftSum == sum) {
                return i;
            }

            leftSum += arr[i];
        }

        return -1;
    }
}