package com.dsa.ds5searching;

public class _03IndexOfFirstOccurrenceInSorted {
    public static void main(String[] args) {

        int[] arr1 = {10, 20, 20, 20, 30, 30, 40};

        System.out.println(findFirstOccurrence(arr1, 10)); // 0
        System.out.println(findFirstOccurrence(arr1, 20)); // 1
        System.out.println(findFirstOccurrence(arr1, 30)); // 4
        System.out.println(findFirstOccurrence(arr1, 40)); // 6
        System.out.println(findFirstOccurrence(arr1, 50)); // -1

        int[] arr2 = {5, 5, 5, 5};
        System.out.println(findFirstOccurrence(arr2, 5)); // 0

        int[] arr3 = {7};
        System.out.println(findFirstOccurrence(arr3, 7)); // 0
        System.out.println(findFirstOccurrence(arr3, 10)); // -1

        int[] arr4 = {};
        System.out.println(findFirstOccurrence(arr4, 5)); // -1
    }

    public static int findFirstOccurrence(int[] arr,int x){
        int start=0;
        int end=arr.length-1;

        while (start<=end){
            int mid=(start+end)/2;
            if (x==arr[mid]){
                if (mid==0 || arr[mid]!=arr[mid-1]){
                    return mid;
                }else {
                    end=mid-1;
                }
            }else if (x<arr[mid]){
                end=mid-1;
            }else {
                start=mid+1;
            }
        }
        return -1;
    }

    public static int findFirstOccurrenceRecursive(int[] arr, int start,int end, int x){
        if (start>end){
            return -1;
        }
        int mid=(start+end)/2;
        int midVal=arr[mid];
        if (x==midVal){
            if (mid==0 || midVal!=arr[mid-1]){
                return mid;
            }else{
                return findFirstOccurrenceRecursive(arr,start,mid-1,x);
            }
        } else if (x<midVal){
            return findFirstOccurrenceRecursive(arr,start,mid-1,x);
        } else {
            return findFirstOccurrenceRecursive(arr,mid+1,end,x);
        }

    }
}
