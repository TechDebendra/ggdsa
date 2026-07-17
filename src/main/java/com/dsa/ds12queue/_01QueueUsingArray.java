package com.dsa.ds12queue;

import java.util.Arrays;

public class _01QueueUsingArray {
    private final int[] array;
    private final int capacity;
    private int rear, front, size;

    public _01QueueUsingArray(int capacity){
        this.capacity = capacity;
        array = new int[capacity];
        this.size = 0;
        this.front = 0;
        this.rear = capacity -1;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public void enqueue(int item){
        if (isFull()){
            throw new IllegalStateException("Overflow!");
        }
        rear = (rear+1)%capacity;
        array[rear] = item;
        size++;
        System.out.println(item+" enqueued!");
    }

    public int dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow!");
        }
        int item = array[front];
        array[front] = 0;
        front = (front+1) % capacity;
        size--;
        System.out.println(item+" dequeued!");
        return item;
    }

    public static void main(String[] args) {
        _01QueueUsingArray myQueue = new _01QueueUsingArray(3);

        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
       // myQueue.dequeue();
        myQueue.enqueue(10);
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);

        System.out.println("Dequeue :"+myQueue.dequeue());
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);

        myQueue.enqueue(20);
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);

        myQueue.enqueue(30);
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);

        System.out.println("Dequeue :"+myQueue.dequeue());
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);

        myQueue.enqueue(40);
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);

        myQueue.enqueue(50);
        System.out.println("Queue :"+Arrays.toString(myQueue.array));
        System.out.println("Size :"+myQueue.size + " Front : "+myQueue.front+" Rear : "+myQueue.rear);

      //  myQueue.enqueue(60);
    }
}
