package com.dsa.ds4array;

import java.util.Arrays;

public class _02DeletionFromArray {

    public static void main(String[] args) {

        // Test 1: Delete existing element
        int[] arr1 = {1, 2, 4, 5, 6, 7, 0, 0};
        int size1 = 6;
        size1 = delete(arr1, size1, 2);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Size = " + size1);

        // Test 2: Delete first element
        int[] arr2 = {1, 2, 3, 4};
        int size2 = 4;
        size2 = delete(arr2, size2, 1);
        System.out.println(Arrays.toString(arr2));

        // Test 3: Delete last element
        int[] arr3 = {1, 2, 3, 4};
        int size3 = 4;
        size3 = delete(arr3, size3, 4);
        System.out.println(Arrays.toString(arr3));

        // Test 4: Element not present
        int[] arr4 = {1, 2, 3, 4};
        int size4 = 4;
        size4 = delete(arr4, size4, 10);
        System.out.println(Arrays.toString(arr4));
        System.out.println("Size = " + size4);
    }

    /**
     * Deletes first occurrence of x from array.
     *
     * @param arr array
     * @param size current number of elements
     * @param x element to delete
     * @return updated size
     */
    public static int delete(int[] arr, int size, int x) {

        int i;

        for (i = 0; i < size; i++) {
            if (arr[i] == x) {
                break;
            }
        }

        if (i == size) {
            return size;
        }

        for (int j = i; j < size - 1; j++) {
            arr[j] = arr[j + 1];
        }

        arr[size - 1] = 0;

        return size - 1;
    }
}