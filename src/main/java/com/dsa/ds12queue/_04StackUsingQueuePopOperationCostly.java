package com.dsa.ds12queue;

import java.util.LinkedList;
import java.util.Queue;

public class _04StackUsingQueuePopOperationCostly {
int size;
    int capacity;
    Queue<Integer> q1  ;
    Queue<Integer> q2  ;

    public _04StackUsingQueuePopOperationCostly(int capacity){
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
        q1.offer(data);
        size++;
    }

    public int pop(){
        if (isEmpty()){
            throw new IllegalStateException("Underflow!");
        }
        while (q1.size() > 1){
            q2.offer(q1.poll());
        }
        int data  = q1.poll();
        size--;

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        q2.clear();

        return data;
    }

    public int peek() {
        if (isEmpty()){
            throw new IllegalStateException("Underflow!");
        }
        while (q1.size() > 1){
            q2.offer(q1.poll());
        }
        int data  = q1.peek();

        q2.offer(q1.poll());

        Queue<Integer> temp = q1;
        q1 = q2;
        q2 = temp;
        q2.clear();

        return data;
    }

    public static void main(String[] args) {

        _04StackUsingQueuePopOperationCostly stack =
                new _04StackUsingQueuePopOperationCostly(5);

        System.out.println("Is Empty : " + stack.isEmpty());
        System.out.println("Size     : " + stack.size());

        stack.push(10);
        stack.push(20);
        stack.push(30);

        System.out.println("\nAfter Push");
        System.out.println("Size : " + stack.size());
        System.out.println("Top  : " + stack.peek());

        System.out.println("\nPop : " + stack.pop());

        System.out.println("\nAfter Pop");
        System.out.println("Size : " + stack.size());
        System.out.println("Top  : " + stack.peek());

        stack.push(40);

        System.out.println("\nAfter Push 40");
        System.out.println("Top  : " + stack.peek());
        System.out.println("Size : " + stack.size());

        System.out.println("\nRemoving All");

        while (!stack.isEmpty()) {
            System.out.println(stack.pop());
        }

        System.out.println("\nIs Empty : " + stack.isEmpty());
    }

}