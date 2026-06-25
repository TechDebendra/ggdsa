package com.dsa.ds6sorting;

import java.util.Arrays;

public class _10InversionsInAnArray {
    public static void main(String[] args) {

        test(new int[]{2,4,1,3,5});
        test(new int[]{5,4,3,2,1});
        test(new int[]{1,2,3,4,5});
        test(new int[]{10});
        test(new int[]{});
        test(new int[]{1,20,6,4,5});
        test(new int[]{8,4,2,1});
    }

    private static void test(int[] arr){

        System.out.println("--------------------------------");
        System.out.println("Array : " + Arrays.toString(arr));

        int ans = arr.length == 0 ? 0 : inversion(arr,0,arr.length-1);

        System.out.println("Inversions = " + ans);
    }

    public static int inversion(int[] arr, int low, int high){
        int res=0;
        if (low<high){
            int middle=low+(high-low)/2;
            res+=inversion(arr,low,middle);
            res+=inversion(arr,middle+1,high);
            res+=merge(arr,low,middle,high);
        }
        return res;
    }

    public static int merge(int[] arr,int low, int middle, int high){
        int n1=middle-low+1;
        int n2=high-middle;
        int res=0;

        int[] arr1 = new int[n1];
        int[] arr2 = new int[n2];

        for (int i=0;i<n1;i++){
            arr1[i]=arr[low+i];
        }
        for (int j=0;j<n2;j++){
            arr2[j]=arr[middle+j+1];
        }
        int i=0,j=0,k=low;
        while (i<n1 && j< n2){
            if (arr1[i]<=arr2[j]){
                arr[k++]=arr1[i++];
            }else {
                arr[k++]=arr2[j++];
                res+=n1-i;
            }
        }

        while (i<n1){
            arr[k++]=arr1[i++];
        }

        while (j<n2){
            arr[k++]=arr2[j++];
        }

        return res;
    }
}
