package com.dsa.ds5searching;

/**
 * Allocate Minimum Pages Problem (Recursive Solution).
 *
 * Given an array where each element represents the number of pages
 * in a book and k students, allocate contiguous books such that
 * the maximum pages assigned to a student is minimized.
 *
 * Time Complexity: Exponential
 * Space Complexity: O(k) recursion stack
 */
public class _16AllocateMinimumPages {

    public static void main(String[] args) {

        int[] arr1 = {10, 20, 30, 40};
        System.out.println(minPages(arr1, arr1.length, 2)); // 60

        int[] arr2 = {10, 20, 30};
        System.out.println(minPages(arr2, arr2.length, 2)); // 30

        int[] arr3 = {10, 5, 30, 1, 2, 5, 10, 10};
        System.out.println(minPages(arr3, arr3.length, 3)); // 35

        int[] arr4 = {12, 34, 67, 90};
        System.out.println(minPages(arr4, arr4.length, 2)); // 113

        int[] arr5 = {15, 17, 20};
        System.out.println(minPages(arr5, arr5.length, 1)); // 52

        int[] arr6 = {100};
        System.out.println(minPages(arr6, arr6.length, 1)); // 100

        int[] arr7 = {10, 20, 30, 40};
        System.out.println(minPages(arr7, arr7.length, 4)); // 40
    }

    /**
     * Computes the sum of array elements from index s to e.
     *
     * @param arr Input array
     * @param s   Start index
     * @param e   End index
     * @return Sum of elements between s and e (inclusive)
     */
    public static int sum(int[] arr, int s, int e) {

        int sum = 0;

        for (int i = s; i <= e; i++) {
            sum += arr[i];
        }

        return sum;
    }

    /**
     * Finds the minimum possible maximum pages assigned to a student.
     *
     * @param arr Array containing pages in each book
     * @param n   Number of books under consideration
     * @param k   Number of students
     * @return Minimum possible maximum pages
     */
    public static int minPages(int[] arr, int n, int k) {

        if (k == 1) {
            return sum(arr, 0, n - 1);
        }

        if (n == 1) {
            return arr[0];
        }

        int res = Integer.MAX_VALUE;

        for (int i = 1; i < n; i++) {

            res = Math.min(
                    res,
                    Math.max(
                            minPages(arr, i, k - 1),
                            sum(arr, i, n - 1)
                    )
            );
        }

        return res;
    }
}