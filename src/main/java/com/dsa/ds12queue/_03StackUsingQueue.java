package com.dsa.ds12queue;

import java.util.LinkedList;
import java.util.Queue;

public class _03StackUsingQueue {
    int size;
    int capacity;
    Queue<Integer> q1  ;
    Queue<Integer> q2  ;

    public _03StackUsingQueue(int capacity){
        this.capacity = capacity;
        this.size = 0;
        this.q1 = new LinkedList<>();
        this.q2 = new LinkedList<>();
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public boolean isFull(){
        return size == capacity;
    }

    public int size(){
        return size;
    }


    public void push(int data){
        if (isFull()){
            throw new IllegalStateException("Overflow!");
        }
        q2.offer(data);

        while (!q1.isEmpty()){
            q2.offer(q1.poll());
        }
        size++;
        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;

        q2.clear();
    }

    public int pop(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow!");
        }
        size--;
        return q1.poll();
    }

    public int peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack is empty");
        }

        return q1.peek();
    }

    public static void main(String[] args) {

        _03StackUsingQueue stack = new _03StackUsingQueue(5);

        System.out.println("Is Empty : " + stack.isEmpty());
        System.out.println("Size     : " + stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nAfter Push");
        System.out.println("Size : " + stack.size());
        System.out.println("Top  : " + stack.q1.peek());

        System.out.println("\nPop : " + stack.pop());

        System.out.println("\nAfter Pop");
        System.out.println("Size : " + stack.size());
        System.out.println("Top  : " + stack.q1.peek());

        stack.push(40);

        System.out.println("\nAfter Push 40");
        System.out.println("Top  : " + stack.q1.peek());
        System.out.println("Size : " + stack.size());

        System.out.println("\nRemoving All");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("\nIs Empty : " + stack.isEmpty());

        // Uncomment to test underflow
        // stack.pop();

        // Uncomment to test overflow
        // stack.push(1);
        // stack.push(2);
        // stack.push(3);
        // stack.push(4);
        // stack.push(5);
        // stack.push(6);
    }

}
