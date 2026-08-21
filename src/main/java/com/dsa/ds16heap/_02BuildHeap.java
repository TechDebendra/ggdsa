package com.dsa.ds16heap;

public class _02BuildHeap {
    public static int[] buildHeap(int[] arr){

        int lastIndex = arr.length - 1;
        int lastParent = (lastIndex - 1)/2;

        for (int i = lastParent ; i >= 0; i--){
            heapifyDown(i,arr);
        }

        return arr;
    }

    public static void heapifyDown(int index, int[] arr) {

        int smallest = index;
        int left = 2 * index + 1;
        int right = 2 * index + 2;

        if (left < arr.length && arr[left] < arr[smallest]) {
            smallest = left;
        }

        if (right < arr.length && arr[right] < arr[smallest]) {
            smallest = right;
        }

        if (smallest != index) {
            swap(arr, index, smallest);
            heapifyDown(smallest, arr);
        }
    }

    public static void swap(int[] arr, int index, int parent){
        int temp = arr[index];
        arr[index] = arr[parent];
        arr[parent] = temp;
    }

}
