package com.dsa.ds13dequeue;

public class _02DequeueEfficientImpl {
    private final int capacity;
    private final int[] arr;
    private int front, size;
    public _02DequeueEfficientImpl(int capacity){
        this.capacity = capacity;
        this.arr = new int[capacity];
        this.size = 0;
        this.front = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public void insertFront(int data){
        if (isFull()){
            throw new IllegalStateException("Overflow");
        }
        front = (front+capacity-1)% capacity;
        arr[front] = data;
        size++;
    }

    public int deleteFront(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow");
        }
        int data = arr[front];
        arr[front] = 0;
        front = (front + 1)% capacity;
        size--;
        return data;
    }

    public void insertRear(int data){
        if (isFull()){
            throw new IllegalStateException("Overflow");
        }
        int newRear = (front + size )%capacity;
        arr[newRear] = data;
        size ++;
    }

    public int deleteRear(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow");
        }
        int rear = getRear();
        int res = arr[rear];
        arr[rear] = 0;
        size --;
        return res;
    }

    public int getRear(){
        if (isEmpty()){
            return -1;
        }
        return (front + size -1) % capacity;
    }

    public int getFront() {
        if (isEmpty()) {
            return -1;
        }
        return arr[front];
    }


    public static void main(String[] args) {

        _02DequeueEfficientImpl deque = new _02DequeueEfficientImpl(5);

        System.out.println("Initially Empty : " + deque.isEmpty());

        deque.insertRear(10);
        deque.insertRear(20);
        deque.insertRear(30);

        deque.insertFront(5);
        deque.insertFront(1);

        System.out.println("Size : " + deque.size());
        System.out.println("Rear Index : " + deque.getRear());

        try {
            deque.insertRear(40);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        System.out.println("Delete Front : " + deque.deleteFront()); // 1
        System.out.println("Delete Front : " + deque.deleteFront()); // 5

        System.out.println("Delete Rear : " + deque.deleteRear()); // 30
        System.out.println("Delete Rear : " + deque.deleteRear()); // 20

        System.out.println("Current Size : " + deque.size());

        System.out.println("Delete Front : " + deque.deleteFront()); // 10

        System.out.println("Is Empty : " + deque.isEmpty());

        try {
            deque.deleteRear();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

}
