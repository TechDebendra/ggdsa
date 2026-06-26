package com.dsa.ds6sorting;

import java.util.Arrays;

public class _15KthElementInAnArray {

    public static void main(String[] args) {

        test(new int[]{10, 4, 5, 8, 11, 6, 26}, 1);
        test(new int[]{10, 4, 5, 8, 11, 6, 26}, 3);
        test(new int[]{10, 4, 5, 8, 11, 6, 26}, 7);

        test(new int[]{7, 10, 4, 3, 20, 15}, 3);

        test(new int[]{5, 3, 8, 5, 2, 5}, 4);

        test(new int[]{7, 7, 7, 7}, 2);

        test(new int[]{10}, 1);

        test(new int[]{8, 5}, 2);

        test(new int[]{-3, 8, -1, 5, -2}, 2);

        test(new int[]{1, 2, 3, 4, 5}, 5);

        // Invalid k
        test(new int[]{1, 2, 3}, 0);
        test(new int[]{1, 2, 3}, 4);
    }

    public static void test(int[] arr, int k) {

        System.out.println("--------------------------------------");
        System.out.println("Array : " + Arrays.toString(arr));
        System.out.println("k = " + k);

        int ans = kthElement(arr, k);

        System.out.println("Answer : " + ans);
    }

    public static int kthElement(int[] arr, int k) {

        if (k < 1 || k > arr.length)
            return -1;

        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {

            int p = partition(arr, low, high);

            if (p == k - 1)
                return arr[p];

            if (p > k - 1)
                high = p - 1;
            else
                low = p + 1;
        }

        return -1;
    }

    public static int partition(int[] arr, int low, int high) {

        int i = low - 1;
        int pivot = arr[high];

        for (int j = low; j < high; j++) {

            if (arr[j] <= pivot) {
                swap(arr, ++i, j);
            }
        }

        swap(arr, ++i, high);

        return i;
    }

    public static void swap(int[] arr, int i, int j) {

        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}