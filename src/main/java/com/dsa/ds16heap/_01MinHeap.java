package com.dsa.ds16heap;

import java.util.ArrayList;
import java.util.List;

public class _01MinHeap {
    private List<Integer> heap;

    public _01MinHeap() {
        heap = new ArrayList<>();
    }

     public void insert(int data){
         heap.add(data);
         heapIfyUp(heap.size()-1);


     }

     public void heapIfyUp(int index){
         while(index > 0){
             int parent = (index-1)/2;
             if(heap.get(parent) <= heap.get(index)){
                 break;
             }
             swap(parent,index);
             index = parent;
         }
     }

     public void swap(int i,int j){
        int temp = heap.get(i);
        heap.set(i,heap.get(j));
        heap.set(j,temp);
     }

     public int peek(){
        if (heap.isEmpty()){
            throw new RuntimeException("Heap is Empty");
        }
        return heap.get(0);
     }

     public int extractMin(){
        if (heap.isEmpty()){
            throw new RuntimeException("Heap is Empty");
        }
        int min = heap.get(0);

        if (heap.size() == 1){
            heap.remove(0);
            return min;
        }

        heap.set(0, heap.get(heap.size()-1));
        heap.remove(heap.size()-1);
        heapIfyDown(0);
        return min;
     }

     public void heapIfyDown(int index){
        int min = index;

        int left = 2*index + 1;
        int right = 2*index + 2;

        int size = heap.size()-1;

        if (left <= size && heap.get(min) > heap.get(left)){
            min = left;
        }

        if (right <= size && heap.get(min) > heap.get(right)){
            min = right;
        }
        if (min == index){
            return;
        }
        swap(min,index);

        index = min;

         heapIfyDown(index);

     }

     public boolean isEmpty(){
        return heap.isEmpty();
     }

    public void decreaseKey(int index, int value) {
        if (index < 0 || index >= heap.size()) {
            throw new IllegalArgumentException("Invalid Index");
        }

        if (value > heap.get(index)) {
            throw new IllegalArgumentException(
                    "New value must be smaller than current value");
        }

        heap.set(index, value);
        heapIfyUp(index);
    }

    public void increaseKey(int index, int value) {
        if (index < 0 || index >= heap.size()) {
            throw new IllegalArgumentException("Invalid Index");
        }

        if (value < heap.get(index)) {
            throw new IllegalArgumentException(
                    "New value must be greater than current value");
        }

        heap.set(index, value);
        heapIfyDown(index);
    }

    public void delete(int index){
        if (index < 0 || index >= heap.size()) {
            throw new IllegalArgumentException("Invalid Index");
        }
        decreaseKey(index,Integer.MIN_VALUE);
        extractMin();
    }


}


