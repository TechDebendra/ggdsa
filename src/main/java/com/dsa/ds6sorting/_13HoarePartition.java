package com.dsa.ds6sorting;

import java.util.Arrays;

public class _13HoarePartition {
    public static void main(String[] args) {

        test(new int[]{10, 80, 30, 90, 40, 50, 70}, 0, 6);

        test(new int[]{5, 13, 6, 9, 12, 8, 11}, 0, 6);

        test(new int[]{9, 8, 7, 1}, 0, 3);

        test(new int[]{4, 1, 7, 9}, 0, 3);

        test(new int[]{5, 3, 8, 5, 2, 5}, 0, 5);

        test(new int[]{7, 7, 7, 7}, 0, 3);

        test(new int[]{10}, 0, 0);

        test(new int[]{8, 5}, 0, 1);

        test(new int[]{20, 15, 5, 18, 10, 30}, 1, 4);

        test(new int[]{-3, 8, -1, 5, -2}, 0, 4);
    }


    public static int hoarePartition(int[] arr, int low, int high){
        int i=low-1;
        int j=high+1;
        int pivot= arr[low];

        while (true){
            do {
                i++;
            }while (arr[i]<pivot);

            do {
                j--;
            }while (arr[j]>pivot);

            if (i>=j)return j;
            int temp = arr[i];
            arr[i]=arr[j];
            arr[j]=temp;

        }

    }

    public static void test(int[] arr, int low, int high) {

        System.out.println("----------------------------------");
        System.out.println("Input : " + Arrays.toString(arr));

        int pivotIndex = hoarePartition(arr, low, high);

        System.out.println("Output: " + Arrays.toString(arr));
        System.out.println("Pivot Index : " + pivotIndex);
        System.out.println("Pivot Value : " + arr[pivotIndex]);
        System.out.println();
    }
}
