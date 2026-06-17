package com.dsa.ds5Searching;

/**
 * Searches an element in a conceptually infinite sorted array.
 *
 * The idea is:
 * 1. Find a range containing the target by doubling the index.
 * 2. Apply Binary Search within that range.
 *
 * Time Complexity: O(log n)
 * Space Complexity: O(1)
 */
public class _08SearchInInfiniteSizedArray {

    public static void main(String[] args) {

        int[] arr = {
                10, 20, 30, 40, 50,
                60, 70, 80, 90, 100,
                110, 120, 130, 140, 150
        };

        System.out.println(search(arr, 10));   // 0
        System.out.println(search(arr, 30));   // 2
        System.out.println(search(arr, 80));   // 7
        System.out.println(search(arr, 150));  // 14
        System.out.println(search(arr, 200));  // -1

        int[] arr2 = {5};
        System.out.println(search(arr2, 5));   // 0
        System.out.println(search(arr2, 10));  // -1

        int[] arr3 = {10, 20};
        System.out.println(search(arr3, 20));  // 1
        System.out.println(search(arr3, 15));  // -1

        int[] arr4 = {};
        System.out.println(search(arr4, 10));  // -1
    }

    /**
     * Searches for an element in a sorted array using
     * the Infinite Array Search technique.
     *
     * @param arr Sorted input array
     * @param x   Element to search
     * @return Index of x if found, otherwise -1
     */
    public static int search(int[] arr, int x) {

        if (arr == null || arr.length == 0) {
            return -1;
        }

        if (arr[0] == x) {
            return 0;
        }

        int i = 1;

        while (i < arr.length && x > arr[i]) {
            i *= 2;
        }

        int end = Math.min(i, arr.length - 1);

        if (arr[end] == x) {
            return end;
        }

        return binarySearch(arr, i / 2 + 1, end - 1, x);
    }

    /**
     * Standard Binary Search.
     *
     * @param arr   Sorted array
     * @param start Starting index
     * @param end   Ending index
     * @param x     Element to search
     * @return Index if found, otherwise -1
     */
    public static int binarySearch(int[] arr, int start, int end, int x) {

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