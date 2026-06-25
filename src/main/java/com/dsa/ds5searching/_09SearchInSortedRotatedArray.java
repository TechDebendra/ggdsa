package com.dsa.ds5searching;

/**
 * Searches an element in a sorted rotated array.
 *
 * Example:
 * [10, 20, 30, 40, 50, 8, 9]
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _09SearchInSortedRotatedArray {

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40, 50, 8, 9};

        System.out.println(search(arr1, 10)); // 0
        System.out.println(search(arr1, 30)); // 2
        System.out.println(search(arr1, 50)); // 4
        System.out.println(search(arr1, 8));  // 5
        System.out.println(search(arr1, 9));  // 6
        System.out.println(search(arr1, 100)); // -1

        int[] arr2 = {30, 40, 50, 10, 20};
        System.out.println(search(arr2, 10)); // 3
        System.out.println(search(arr2, 40)); // 1

        int[] arr3 = {5};
        System.out.println(search(arr3, 5));  // 0
        System.out.println(search(arr3, 10)); // -1

        int[] arr4 = {3, 1};
        System.out.println(search(arr4, 3)); // 0
        System.out.println(search(arr4, 1)); // 1

        int[] arr5 = {};
        System.out.println(search(arr5, 10)); // -1
    }

    /**
     * Searches for an element in a sorted rotated array.
     *
     * @param arr Sorted rotated array
     * @param x   Element to search
     * @return Index of x if found, otherwise -1
     */
    public static int search(int[] arr, int x) {

        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            if (arr[mid] == x) {
                return mid;
            }

            // Left half sorted
            if (arr[start] <= arr[mid]) {

                if (x >= arr[start] && x < arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }

            }
            // Right half sorted
            else {

                if (x > arr[mid] && x <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        return -1;
    }
}