package com.dsa.ds6sorting;
import java.util.Arrays;

public class _14QuickSortNaivePartition {

    public static void main(String[] args) {

        // Test Case 1: Normal Case
        test(new int[]{5, 13, 6, 9, 12, 8, 11});

        // Test Case 2: Random Elements
        test(new int[]{10, 80, 30, 90, 40, 50, 70});

        // Test Case 3: Already Sorted
        test(new int[]{1, 2, 3, 4, 5});

        // Test Case 4: Reverse Sorted
        test(new int[]{5, 4, 3, 2, 1});

        // Test Case 5: Duplicate Elements
        test(new int[]{5, 3, 8, 5, 2, 5});

        // Test Case 6: All Elements Same
        test(new int[]{7, 7, 7, 7});

        // Test Case 7: Single Element
        test(new int[]{10});

        // Test Case 8: Two Elements
        test(new int[]{8, 5});

        // Test Case 9: Negative Numbers
        test(new int[]{-3, 8, -1, 5, -2});

        // Test Case 10: Mixed Positive & Negative
        test(new int[]{3, -2, 7, 0, -5, 8, 1});

        // Test Case 11: Empty Array
        test(new int[]{});

        // Test Case 12: Large Duplicate Values
        test(new int[]{4, 4, 2, 2, 5, 5, 1, 1});
    }

    public static void test(int[] arr) {

        System.out.println("----------------------------------------");
        System.out.println("Input  : " + Arrays.toString(arr));

        if (arr.length > 0)
            quickSort(arr, 0, arr.length - 1);

        System.out.println("Output : " + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {

        if (low < high) {

            int partition = partition(arr, low, high);

            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {

        int[] temp = new int[high - low + 1];

        int pivot = arr[high];

        int index = 0;
        int res;

        for (int i = low; i <= high - 1; i++) {
            if (arr[i] <= pivot) {
                temp[index++] = arr[i];
            }
        }

        res = index;
        temp[index++] = pivot;

        for (int i = low; i <= high - 1; i++) {
            if (arr[i] > pivot) {
                temp[index++] = arr[i];
            }
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i - low];
        }

        return res + low;
    }
}