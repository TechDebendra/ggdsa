package com.dsa.ds4array;

/**
 * Finds the maximum sum of a contiguous subarray
 * using Kadane's Algorithm.
 */
public class _05LargestSumSubarray {

    public static void main(String[] args) {

        // Test Case 1
        int[] arr1 = {1, -2, 3, -1, 2};
        System.out.println(maxSum(arr1)); // 4
        findMaxSumArray(arr1);

        // Test Case 2
        int[] arr2 = {-3, 8, -2, 4, -5, 6};
        System.out.println(maxSum(arr2)); // 11

        // Test Case 3: All positive
        int[] arr3 = {1, 2, 3, 4};
        System.out.println(maxSum(arr3)); // 10

        // Test Case 4: All negative
        int[] arr4 = {-8, -3, -6, -2, -5, -4};
        System.out.println(maxSum(arr4)); // -2

        // Test Case 5: Single positive element
        int[] arr5 = {5};
        System.out.println(maxSum(arr5)); // 5

        // Test Case 6: Single negative element
        int[] arr6 = {-5};
        System.out.println(maxSum(arr6)); // -5

        // Test Case 7
        int[] arr7 = {5, -2, 3, 4};
        System.out.println(maxSum(arr7)); // 10

        // Test Case 8
        int[] arr8 = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSum(arr8)); // 6
    }

    /**
     * Returns the maximum sum of a contiguous subarray.
     *
     * @param arr input array
     * @return maximum subarray sum
     */
    public static int maxSum(int[] arr) {

        int maxSum = Integer.MIN_VALUE;
        int tempMax = 0;

        for (int i = 0; i < arr.length; i++) {

            tempMax += arr[i];

            if (maxSum < tempMax) {
                maxSum = tempMax;
            }

            if (tempMax < 0) {
                tempMax = 0;
            }
        }

        return maxSum;
    }

    public static void findMaxSumArray(int[] arr){
        int tempStart=0;
        int start=0;
        int end=0;

        int maxSum=Integer.MIN_VALUE;
        int temp=0;

        for (int i=0;i< arr.length;i++){

            temp+=arr[i];
            if (maxSum<temp){
                maxSum=temp;
                start=tempStart;
                end=i;
            }

            if (temp<0){
                temp=0;
                tempStart=i+1;
            }

        }

        System.out.println("\nMax subarray:");
        for (int i=start;i<=end;i++){
            System.out.print(arr[i]+" ");
        }
        System.out.println("\n");

    }
}