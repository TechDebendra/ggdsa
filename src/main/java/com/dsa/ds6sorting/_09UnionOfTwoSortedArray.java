package com.dsa.ds6sorting;

import java.util.Arrays;

public class _09UnionOfTwoSortedArray {

    public static void main(String[] args) {

        test(new int[]{10, 20, 20, 40}, new int[]{20, 30, 40, 50});

        test(new int[]{1, 2, 3}, new int[]{});

        test(new int[]{}, new int[]{4, 5, 6});

        test(new int[]{1, 1, 1}, new int[]{1, 1, 2});

        test(new int[]{1, 3, 5}, new int[]{2, 4, 6});

        test(new int[]{1, 2, 3}, new int[]{1, 2, 3});

        test(new int[]{}, new int[]{});
    }

    private static void test(int[] arr1, int[] arr2) {
        System.out.println("--------------------------------");
        System.out.println("Array1 : " + Arrays.toString(arr1));
        System.out.println("Array2 : " + Arrays.toString(arr2));
        System.out.print("Union  : ");
        union(arr1, arr2);
        System.out.println();
    }

    public static void union(int[] arr1, int[] arr2) {

        int n1 = arr1.length;
        int n2 = arr2.length;

        int i = 0;
        int j = 0;

        while (i < n1 && j < n2) {

            if (i > 0 && arr1[i] == arr1[i - 1]) {
                i++;
                continue;
            }

            if (j > 0 && arr2[j] == arr2[j - 1]) {
                j++;
                continue;
            }

            if (arr1[i] < arr2[j]) {
                System.out.print(arr1[i] + " ");
                i++;
            } else if (arr1[i] > arr2[j]) {
                System.out.print(arr2[j] + " ");
                j++;
            } else {
                System.out.print(arr1[i] + " ");
                i++;
                j++;
            }
        }

        while (i < n1) {

            if (i == 0 || arr1[i] != arr1[i - 1]) {
                System.out.print(arr1[i] + " ");
            }

            i++;
        }

        while (j < n2) {

            if (j == 0 || arr2[j] != arr2[j - 1]) {
                System.out.print(arr2[j] + " ");
            }

            j++;
        }
    }
}