package com.dsa.ds20dynamicprograming;

import java.util.Arrays;

public class _09LongestIncreasingSubsequence_DP {

    public static int lis(int[] arr){
        int n = arr.length;
        int[] lis = new int[n];

        Arrays.fill(lis,1);

        for (int i =1 ; i < n ; i++){
            for (int j = 0 ; j < i ; j++){
                if (arr[j] < arr[i] ){
                    lis[i] = Math.max(lis[i],lis[j]+1);
                }
            }
        }

        int result = Integer.MIN_VALUE;

        for (int i : lis){
            result = Math.max(i,result);
        }

        return result;
    }

    public static void main(String[] args) {
        int arr[] = { 10, 22, 9, 33, 21, 50, 41, 60 };
        System.out.println("Length of lis is " + lis(arr));
    }
}
