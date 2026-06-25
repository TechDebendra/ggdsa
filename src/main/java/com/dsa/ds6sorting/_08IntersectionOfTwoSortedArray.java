package com.dsa.ds6sorting;

import java.util.Arrays;

public class _08IntersectionOfTwoSortedArray {
    public static void main(String[] args) {

        test(new int[]{1, 2, 3, 4}, new int[]{2, 4, 6});

        test(new int[]{10, 20, 20, 30, 40}, new int[]{20, 20, 40, 50});

        test(new int[]{1, 2, 3}, new int[]{4, 5, 6});

        test(new int[]{}, new int[]{1, 2});

        test(new int[]{1, 2}, new int[]{});

        test(new int[]{1, 1, 1, 1}, new int[]{1, 1, 1});

        test(new int[]{2, 4, 6, 8}, new int[]{2, 4, 6, 8});

        test(new int[]{1, 3, 5}, new int[]{1, 3, 5});
    }

    private static void test(int[] arr1, int[] arr2) {
        System.out.println("----------------------------------");
        System.out.println("Array1 : " + Arrays.toString(arr1));
        System.out.println("Array2 : " + Arrays.toString(arr2));
        System.out.print("Intersection : ");
        intersection(arr1, arr2);
        System.out.println();
    }
    public static void intersection(int[] arr1, int[] arr2){
        int n1=arr1.length;
        int n2=arr2.length;

        int i=0,j=0;
        while (i<n1 && j<n2){
            if (i>0 && arr1[i]==arr1[i-1]){
                i++;
                continue;
            }

            if (arr1[i]<arr2[j]){
                i++;
            } else if (arr1[i]>arr2[j])  {
                j++;
            }else {
                System.out.println(arr1[i]);
                i++;
                j++;
            }
        }
    }
}
