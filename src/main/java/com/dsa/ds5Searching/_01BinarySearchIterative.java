package com.dsa.ds5Searching;

/**
 * Binary Search using Iterative approach.
 *
 * <p>Binary Search works only on a sorted array.
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _01BinarySearchIterative {

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40, 50, 60};

        // Test Case 1: Element present in middle
        System.out.println(binarySearch(arr1, 30)); // 2

        // Test Case 2: First element
        System.out.println(binarySearch(arr1, 10)); // 0

        // Test Case 3: Last element
        System.out.println(binarySearch(arr1, 60)); // 5

        // Test Case 4: Element not present
        System.out.println(binarySearch(arr1, 35)); // -1

        // Test Case 5: Single element array (found)
        int[] arr2 = {100};
        System.out.println(binarySearch(arr2, 100)); // 0

        // Test Case 6: Single element array (not found)
        System.out.println(binarySearch(arr2, 50)); // -1

        // Test Case 7: Empty array
        int[] arr3 = {};
        System.out.println(binarySearch(arr3, 10)); // -1

        // Test Case 8: Negative numbers
        int[] arr4 = {-20, -10, 0, 10, 20};
        System.out.println(binarySearch(arr4, -10)); // 1
    }

    /**
     * Searches for a given element in a sorted array using Binary Search.
     *
     * @param arr Sorted input array
     * @param x   Element to search
     * @return Index of the element if found, otherwise -1
     */
    public static int binarySearch(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                return mid;
            } else if (x < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
}