package com.dsa.ds11stack;

public class _14StackWithGetMinimumOptimised {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    private Node head;
    private final int capacity;
    private int top;
    private int min;

    _14StackWithGetMinimumOptimised(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.head = null;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int x) {

        if (top == capacity - 1) {
            throw new IllegalStateException("Stack Overflow");
        }

        if (isEmpty()) {
            head = new Node(x);
            min = x;
            top++;
            return;
        }

        Node temp;

        if (x >= min) {
            temp = new Node(x);
        } else {
            temp = new Node(2 * x - min);
            min = x;
        }

        temp.next = head;
        head = temp;
        top++;
    }

    public int pop() {

        if (isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }

        top--;

        int value = head.data;
        head = head.next;

        // Normal value
        if (value >= min) {
            return value;
        }

        // Encoded value
        int actualValue = min;
        min = 2 * min - value;

        return actualValue;
    }

    public int peek() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty Stack");
        }

        if (head.data >= min) {
            return head.data;
        }

        return min;
    }

    public int getMin() {

        if (isEmpty()) {
            throw new IllegalStateException("Empty Stack");
        }

        return min;
    }

    public static void main(String[] args) {

        _14StackWithGetMinimumOptimised stack =
                new _14StackWithGetMinimumOptimised(10);

        stack.push(5);
        stack.push(3);
        stack.push(7);
        stack.push(2);
        stack.push(8);

        System.out.println("Min  : " + stack.getMin()); //2
        System.out.println("Peek : " + stack.peek());   //8

        System.out.println("Pop  : " + stack.pop());    //8
        System.out.println("Min  : " + stack.getMin()); //2

        System.out.println("Pop  : " + stack.pop());    //2
        System.out.println("Min  : " + stack.getMin()); //3

        System.out.println("Peek : " + stack.peek());   //7
    }
}