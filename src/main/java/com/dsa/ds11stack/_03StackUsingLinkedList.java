package com.dsa.ds11stack;

public class _03StackUsingLinkedList {

    class Node{
        Node next;
        int data;
        Node(int x){
            this.data = x;
        }
    }

    Node head;
    int size;

    _03StackUsingLinkedList(){
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty(){
        return head == null;
    }

    public int size(){
        return size;
    }

    public void push(int x){
        Node temp = new Node(x);
        temp.next = head;
        head = temp;
        size++;
    }

    public int pop(){
        if( head == null){
            throw new IllegalStateException("Stack Underflow");
        }

        int data = head.data;;
        head = head.next;
        size--;

        return data;
    }

    public int peek(){
        if( head == null){
            throw new IllegalStateException("Stack Underflow");
        }
        return head.data;
    }

    public static void main(String[] args) {
        _03StackUsingLinkedList myStack = new _03StackUsingLinkedList();

        myStack.push(10);
        System.out.println("Size : "+myStack.size());
        System.out.println(myStack.peek());

        System.out.println(myStack.pop());
        System.out.println("Is stack is empty :"+myStack.isEmpty());
        System.out.println("Size : "+myStack.size());

        //   System.out.println(stackUsingArray.pop());
        myStack.push(20);
        myStack.push(30 );
        myStack.push(50);
        System.out.println("Is stack is empty :"+myStack.isEmpty());
        System.out.println("Size : "+myStack.size());

        // stackUsingArray.push(60);
    }
}
