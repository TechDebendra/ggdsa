package com.dsa.ds16heap;

import java.util.Arrays;

public class _03HeapSort {

    public static void main(String[] args) {
        int[] input = {2,1,43,23,87,43,100};
        System.out.println(Arrays.toString(input));
        heapSort(input);

        System.out.println("After sorting :");
        System.out.println(Arrays.toString(input));
    }

    public static int[] heapSort(int[] arr){

        // Build heap
        int lastIndex = arr.length -1 ;
        int lastParent = (lastIndex-1)/2;

        for (int i = lastParent ; i >= 0 ; i-- ){
            heapifyDown(arr,i,arr.length);
        }
        System.out.println("Heap");
        System.out.println(Arrays.toString(arr));

        // Now arr presenting a heap
        // Sorting by placing largest at correct place
        for (int i = arr.length -1 ; i>=0 ; i--){
            swap(arr,0,i);
            heapifyDown(arr,0,i);
        }

        return arr;
    }

    public static void heapifyDown(int[] arr, int index, int size){

        if (index < 0 || index > size){
            return;
        }

        int max = index;

        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < size && arr[max] < arr[left]){
            max = left;
        }

        if (right < size && arr[max] < arr[right]){
            max = right;
        }

        if (max != index){
            swap(arr,max, index);
            heapifyDown(arr,max,size);

        }

    }

    public static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i]  = arr[j];
        arr[j] = temp;
    }
}
