package com.dsa.ds5Searching;

/**
 * Finds a repeating element in an array using an auxiliary
 * boolean array.
 *
 * Assumption:
 * - Array contains non-negative integers.
 * - At least one element is repeated.
 *
 * Time Complexity: O(n)
 * Space Complexity: O(n)
 */
public class _14RepeatingElementPart1 {

    public static void main(String[] args) {

        int[] arr1 = {0, 2, 1, 3, 2};
        System.out.println(findRepeatingElement(arr1)); // 2

        int[] arr2 = {1, 3, 2, 4, 3};
        System.out.println(findRepeatingElement(arr2)); // 3

        int[] arr3 = {0, 0};
        System.out.println(findRepeatingElement(arr3)); // 0

        int[] arr4 = {1, 2, 3, 4, 4};
        System.out.println(findRepeatingElement(arr4)); // 4

        int[] arr5 = {2, 1, 0, 2};
        System.out.println(findRepeatingElement(arr5)); // 2

        int[] arr6 = {1, 2, 3, 4};
        System.out.println(findRepeatingElement(arr6)); // -1

        int[] arr7 = {};
        System.out.println(findRepeatingElement(arr7)); // -1
    }

    /**
     * Finds a repeating element in the array.
     *
     * @param arr Input array
     * @return Repeating element if found, otherwise -1
     */
    public static int findRepeatingElement(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        boolean[] visited = new boolean[arr.length];

        for (int num : arr) {

            if (num < 0 || num >= visited.length) {
                throw new IllegalArgumentException(
                        "Array contains invalid value: " + num);
            }

            if (visited[num]) {
                return num;
            }

            visited[num] = true;
        }

        return -1;
    }
}