package com.dsa.ds5searching;

public class _04IndexOfLastOccurrenceInSorted {
    public static void main(String[] args) {

        int[] arr1 = {10, 20, 20, 20, 30, 30, 40};

        System.out.println(lastOccurrence(arr1, 10)); // 0
        System.out.println(lastOccurrence(arr1, 20)); // 3
        System.out.println(lastOccurrence(arr1, 30)); // 5
        System.out.println(lastOccurrence(arr1, 40)); // 6
        System.out.println(lastOccurrence(arr1, 50)); // -1

        int[] arr2 = {5, 5, 5, 5};
        System.out.println(lastOccurrence(arr2, 5)); // 3

        int[] arr3 = {7};
        System.out.println(lastOccurrence(arr3, 7)); // 0
        System.out.println(lastOccurrence(arr3, 10)); // -1

        int[] arr4 = {};
        System.out.println(lastOccurrence(arr4, 5)); // -1
    }
    /**
     * Finds the index of the last occurrence of a given element
     * in a sorted array using Binary Search.
     *
     * @param arr Sorted input array
     * @param x Element to search
     * @return Index of the last occurrence if found, otherwise -1
     *
     * Time Complexity: O(log n)
     * Space Complexity: O(1)
     */
    public static int lastOccurrence(int[] arr,int x){
        int n=arr.length-1;
        int start=0;
        int end=n;

        while (start<=end){
            int mid=(start+end)/2;
            if (x==arr[mid]){
                if (mid == n || arr[mid]!=arr[mid+1]){
                    return mid;
                }else {
                    start=mid+1;
                }
            }else if (x<arr[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }

        return -1;
    }
}
