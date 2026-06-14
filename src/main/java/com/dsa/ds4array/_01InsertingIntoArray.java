package com.dsa.ds4array;

import java.util.Arrays;

public class _01InsertingIntoArray {

    public static void main(String[] args) {

        // Test Case 1: Insert in middle
        int[] arr1 = {1, 2, 4, 5, 6, 7, 0, 0};
        int size1 = 6;
        size1 = insert(arr1, size1, arr1.length, 3, 3);
        System.out.println(Arrays.toString(arr1));
        System.out.println("Size = " + size1);

        // Test Case 2: Insert at beginning
        int[] arr2 = {2, 3, 4, 5, 0};
        int size2 = 4;
        size2 = insert(arr2, size2, arr2.length, 1, 1);
        System.out.println(Arrays.toString(arr2));

        // Test Case 3: Insert at end
        int[] arr3 = {1, 2, 3, 4, 0};
        int size3 = 4;
        size3 = insert(arr3, size3, arr3.length, 5, 5);
        System.out.println(Arrays.toString(arr3));

        // Test Case 4: Array full
        int[] arr4 = {1, 2, 3, 4};
        int size4 = 4;
        size4 = insert(arr4, size4, arr4.length, 5, 3);
        System.out.println(Arrays.toString(arr4));
        System.out.println("Size = " + size4);

        // Test Case 5: Invalid position
        int[] arr5 = {1, 2, 3, 4, 0};
        int size5 = 4;
        size5 = insert(arr5, size5, arr5.length, 10, 7);
        System.out.println(Arrays.toString(arr5));
    }

    /**
     * Inserts x at the given 1-based position.
     *
     * @param arr      target array
     * @param size     current number of elements
     * @param capacity array capacity
     * @param x        element to insert
     * @param pos      1-based insertion position
     * @return updated size
     */
    public static int insert(int[] arr, int size, int capacity, int x, int pos) {

        if (size == capacity) {
            System.out.println("Array is full");
            return size;
        }

        if (pos < 1 || pos > size + 1) {
            System.out.println("Invalid position");
            return size;
        }

        int index = pos - 1;

        for (int i = size - 1; i >= index; i--) {
            arr[i + 1] = arr[i];
        }

        arr[index] = x;

        return size + 1;
    }
}