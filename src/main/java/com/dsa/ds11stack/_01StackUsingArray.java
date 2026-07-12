package com.dsa.ds11stack;

public class _01StackUsingArray {
    int capacity;
    int top;
    int[] arr;

    public _01StackUsingArray(int capacity){
        this.capacity = capacity;
        this.top = -1;
        this.arr = new int[capacity];
    }

    public boolean isEmpty(){
        return top == -1;
    }

    public int size(){
        return top+1;
    }

    public int pop(){
        if (top == -1){
            throw new IllegalStateException("Stack Overflow");
        }
        int res = arr[top];
        top--;
        return res;

    }

    public int peek(){
        if (top == -1){
            throw new IllegalStateException("Stack Underflow");
        }

        return arr[top];

    }

    public void push(int x){
        if (top == capacity -1){
            throw new RuntimeException("Stack Overflow!");
        }
        arr[++top] = x;

    }

    public static void main(String[] args) {
        _01StackUsingArray stackUsingArray = new _01StackUsingArray(3);
        stackUsingArray.push(10);
        System.out.println("Size : "+stackUsingArray.size());
        System.out.println(stackUsingArray.peek());

        System.out.println(stackUsingArray.pop());
        System.out.println("Is stack is empty :"+stackUsingArray.isEmpty());
        System.out.println("Size : "+stackUsingArray.size());

     //   System.out.println(stackUsingArray.pop());
        stackUsingArray.push(20);
        stackUsingArray.push(30 );
        stackUsingArray.push(50);
        System.out.println("Is stack is empty :"+stackUsingArray.isEmpty());
        System.out.println("Size : "+stackUsingArray.size());

       // stackUsingArray.push(60);
    }
}
