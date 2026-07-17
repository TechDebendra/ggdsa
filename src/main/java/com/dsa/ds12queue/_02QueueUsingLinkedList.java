package com.dsa.ds12queue;

public class _02QueueUsingLinkedList {

    static class Node{
        int data;
        Node next;
        public Node(int data){
            this.data = data;
        }
    }

    Node front;
    Node rear;
    int size;
    int capacity;

    public _02QueueUsingLinkedList(int capacity){
        this.front = null;
        this.rear = null;
        this.size = 0;
        this.capacity = capacity;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public int size(){
        return size;
    }

    public void enqueue(int data){
        if (isFull()){
            throw new IllegalStateException("Overflow!");
        }
        Node temp = new Node(data);
        if (rear == null){
            rear = front = temp;
            size++;
            return;
        }
        rear.next = temp;
        rear = rear.next;
        size++;
    }

    public int dequeue(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow!");
        }
        int data = front.data;
        front = front.next;

        if (front == null){
            rear = null;
        }

        size--;
        return data;
    }

    public static void main(String[] args) {

        _02QueueUsingLinkedList queue = new _02QueueUsingLinkedList(3);

        System.out.println("Queue Empty : " + queue.isEmpty());
        System.out.println("Size : " + queue.size());

        queue.enqueue(10);
        queue.enqueue(20);
        queue.enqueue(30);

        System.out.println("\nAfter Enqueue");
        System.out.println("Front : " + queue.front.data);
        System.out.println("Rear  : " + queue.rear.data);
        System.out.println("Size  : " + queue.size());

        System.out.println("\nDequeued : " + queue.dequeue());

        System.out.println("\nAfter One Dequeue");
        System.out.println("Front : " + queue.front.data);
        System.out.println("Rear  : " + queue.rear.data);
        System.out.println("Size  : " + queue.size());

        queue.enqueue(40);

        System.out.println("\nAfter Enqueue 40");
        System.out.println("Front : " + queue.front.data);
        System.out.println("Rear  : " + queue.rear.data);
        System.out.println("Size  : " + queue.size());

        System.out.println("\nRemoving All Elements");

        while (!queue.isEmpty()) {
            System.out.println(queue.dequeue());
        }

        System.out.println("\nQueue Empty : " + queue.isEmpty());
        System.out.println("Size : " + queue.size());

        // Uncomment to test Underflow
        // queue.dequeue();

        // Uncomment to test Overflow
        // queue.enqueue(1);
        // queue.enqueue(2);
        // queue.enqueue(3);
        // queue.enqueue(4);
    }

}
