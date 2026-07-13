package com.dsa.ds11stack;

public class _13StackWithGetMinimum {
    class Node{
        int data;
        Node next;
        Node(int data){
            this.data = data;
        }
    }

    Node head;
    int capacity;
    int top;
    Node min;

    _13StackWithGetMinimum(int capacity){
        this.capacity = capacity;
        top = -1;
        head = null;
        min = null;
    }

    public int size(){
        return top+1;
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public void push(int x){
        if (top == capacity-1){
            throw new IllegalStateException("Overflow!");
        }
        top++;
        Node temp = new Node(x);
        temp.next = head;
        head = temp;

        if (min == null || min.data >= x){
            Node newMin = new Node(x);
            newMin.next = min;
            min = newMin;
        }
    }

    public int pop(){
        if (top == -1 ){
            throw new IllegalStateException("Underflow!");
        }
        top--;
        int data = head.data;
        head = head.next;

        if (min != null && min.data==data){
            min = min.next;
        }


        return data;
    }

    public int peek(){
        if (head == null ){
            throw new IllegalStateException("Empty Stack!");
        }
        return head.data;
    }

    public int getMin(){
        if (min != null){
            return min.data;
        }
        throw new IllegalStateException("Empty Stack!");
    }

    public static void main(String[] args) {
        _13StackWithGetMinimum s = new _13StackWithGetMinimum(5);

        // Function calls
        s.push(-1);
        s.push(10);
        s.push(-4);
        s.push(0);
        System.out.println(s.getMin());
        System.out.println(s.pop());
        System.out.println(s.pop());
        System.out.println(s.getMin());
    }


}
