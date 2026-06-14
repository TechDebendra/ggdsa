package com.dsa.ds4array;

/**
 * Finds the largest element in an array.
 */
public class _07LargestElementInArray {

    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = {10, 5, 20, 8};
        System.out.println(findLargestElement(arr1)); // 20

        // Test Case 2
        int[] arr2 = {7};
        System.out.println(findLargestElement(arr2)); // 7

        // Test Case 3
        int[] arr3 = {-5, -2, -10, -1};
        System.out.println(findLargestElement(arr3)); // -1

        // Test Case 4
        int[] arr4 = {4, 4, 4, 4};
        System.out.println(findLargestElement(arr4)); // 4

        // Test Case 5
        int[] arr5 = {1, 2, 3, 4, 5};
        System.out.println(findLargestElement(arr5)); // 5
    }

    /**
     * Returns the largest element in the array.
     *
     * @param arr input array
     * @return largest element
     */
    public static int findLargestElement(int[] arr) {

        int largest = arr[0];

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }
}