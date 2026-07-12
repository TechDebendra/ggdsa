package com.dsa.ds11stack;

import java.util.ArrayList;

public class _02StackUsingArrayList {
    int capacity;
    ArrayList<Integer> list;

    public  _02StackUsingArrayList(int capacity){
        this.capacity = capacity;
        this.list = new ArrayList<>();
    }

    public boolean isEmpty(){
        return list.isEmpty();
    }

    public int size(){
        return list.size();
    }

    public void push(int x){
        if (list.size() == capacity){
            throw new IllegalStateException("Stack Overflow");
        }

        list.add(x);
    }

    public int pop() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }

        int res = list.get(list.size() - 1);
        list.remove(list.size() - 1);
        return res;
    }

    public int peek() {
        if (list.isEmpty()) {
            throw new IllegalStateException("Stack Underflow");
        }
        return list.get(list.size() - 1);
    }

    public boolean isFull(){
        return list.size() == capacity ;
    }

    public static void main(String[] args) {
        _02StackUsingArrayList stackUsingArray = new _02StackUsingArrayList(3);
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
