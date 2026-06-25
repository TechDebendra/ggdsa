package com.dsa.ds5searching;

/**
 * Ternary Search implementation for a sorted array.
 *
 * Ternary Search divides the search space into three parts
 * and checks two middle positions.
 *
 * Time Complexity: O(log3 n)
 * Space Complexity: O(1)
 */
public class _01TernarySearch {

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40, 50, 60, 70};

        System.out.println(ternarySearch(arr1, 10)); // 0
        System.out.println(ternarySearch(arr1, 40)); // 3
        System.out.println(ternarySearch(arr1, 70)); // 6
        System.out.println(ternarySearch(arr1, 25)); // -1

        int[] arr2 = {5};
        System.out.println(ternarySearch(arr2, 5));  // 0
        System.out.println(ternarySearch(arr2, 10)); // -1

        int[] arr3 = {};
        System.out.println(ternarySearch(arr3, 10)); // -1

        int[] arr4 = {-20, -10, 0, 10, 20};
        System.out.println(ternarySearch(arr4, -10)); // 1
        System.out.println(ternarySearch(arr4, 20));  // 4

        int[] arr5 = {1, 2};
        System.out.println(ternarySearch(arr5, 1)); // 0
        System.out.println(ternarySearch(arr5, 2)); // 1
    }

    /**
     * Searches for an element in a sorted array using Ternary Search.
     *
     * @param arr Sorted input array
     * @param x   Element to search
     * @return Index of x if found, otherwise -1
     */
    public static int ternarySearch(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid1 = start + (end - start) / 3;
            int mid2 = end - (end - start) / 3;

            if (arr[mid1] == x) {
                return mid1;
            }

            if (arr[mid2] == x) {
                return mid2;
            }

            if (x < arr[mid1]) {

                end = mid1 - 1;

            } else if (x > arr[mid2]) {

                start = mid2 + 1;

            } else {

                start = mid1 + 1;
                end = mid2 - 1;
            }
        }

        return -1;
    }
}