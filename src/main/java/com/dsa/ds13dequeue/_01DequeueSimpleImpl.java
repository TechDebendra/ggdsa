package com.dsa.ds13dequeue;

public class _01DequeueSimpleImpl {
    private int size;
    private final int capacity;
    private final int[] arr;

    public _01DequeueSimpleImpl(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
    }

    public boolean isEmpty(){
        return  size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int size(){
        return size;
    }

    public void insertFront(int data){
        if (isFull()){
            throw new IllegalStateException("Overflow!");
        }

        for (int i=size;i>0;i--){
            arr[i] = arr[i-1];
        }
        arr[0] = data;
        size++;
    }

    public int deleteFront(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow!");
        }
        int res = arr[0];
        for (int i=0;i<size-1;i++){
            arr[i] = arr[i+1];
        }
        size --;

        return res;

    }

    public void insertRear(int data){
        if (isFull()){
            throw new IllegalStateException("Overflow!");
        }
        arr[size] = data;
        size++;
    }

    public int deleteRear(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow!");
        }
        int res = arr[size-1];
        size--;
        return res;
    }

    public int getRear(){
        if (isEmpty()){
            return -1;
        }
        return size-1;
    }

    public int getFront(){
        if (isEmpty()){
            return -1;
        }
        return 0;
    }

    public static void main(String[] args) {

        _01DequeueSimpleImpl deque = new _01DequeueSimpleImpl(5);

        System.out.println("Initially Empty : " + deque.isEmpty());

        // Insert at rear
        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertRear(30);

        System.out.println("Size after inserting at rear : " + deque.size());

        // Insert at front
        deque.insertFront(5);
        deque.insertFront(1);

        System.out.println("Deque is full : " + deque.isFull());

        // Overflow Test
        try {
            deque.insertRear(40);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Delete Front : " + deque.deleteFront()); //1
        System.out.println("Delete Front : " + deque.deleteFront()); //5

        System.out.println("Delete Rear : " + deque.deleteRear()); //30
        System.out.println("Delete Rear : " + deque.deleteRear()); //20

        System.out.println("Current Size : " + deque.size());

        System.out.println("Delete Front : " + deque.deleteFront()); //10

        System.out.println("Is Empty : " + deque.isEmpty());

        // Underflow Test
        try {
            deque.deleteFront();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
