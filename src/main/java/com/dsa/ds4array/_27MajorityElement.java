package com.dsa.ds4array;

/**
 * Majority Element using Moore's Voting Algorithm.
 *
 * <p>A majority element is an element that appears
 * more than n/2 times in the array.
 *
 * <p>Approach:
 * <ol>
 *     <li>Find a candidate using Moore's Voting Algorithm.</li>
 *     <li>Verify whether the candidate is actually a majority element.</li>
 * </ol>
 *
 * <p>Time Complexity: O(n)
 * <br>Space Complexity: O(1)
 */
public class _27MajorityElement {

    public static void main(String[] args) {

        int[] arr1 = {8, 8, 6, 6, 6, 4, 6};
        printResult(arr1);
        // Expected: Index of 6

        int[] arr2 = {1, 2, 3, 4};
        printResult(arr2);
        // Expected: No majority element

        int[] arr3 = {2, 2, 2, 2};
        printResult(arr3);
        // Expected: Index of 2

        int[] arr4 = {3, 3, 4, 2, 4, 4, 2, 4, 4};
        printResult(arr4);
        // Expected: Index of 4

        int[] arr5 = {1};
        printResult(arr5);
        // Expected: Index 0

        int[] arr6 = {1, 1, 2, 2};
        printResult(arr6);
        // Expected: No majority element
    }

    private static void printResult(int[] arr) {

        int index = findMajority(arr);

        if (index == -1) {
            System.out.println("No majority element");
        } else {
            System.out.println(
                    "Majority Element: " + arr[index]
                            + ", Index: " + index);
        }
    }

    /**
     * Returns the index of a majority element if present,
     * otherwise returns -1.
     *
     * @param arr input array
     * @return index of majority element or -1
     */
    public static int findMajority(int[] arr) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        int majIndex = 0;
        int count = 1;

        // Phase 1: Find candidate
        for (int i = 1; i < arr.length; i++) {

            if (arr[i] == arr[majIndex]) {
                count++;
            } else {
                count--;
            }

            if (count == 0) {
                majIndex = i;
                count = 1;
            }
        }

        // Phase 2: Verify candidate
        count = 0;

        for (int value : arr) {
            if (value == arr[majIndex]) {
                count++;
            }
        }

        return (count > arr.length / 2) ? majIndex : -1;
    }
}