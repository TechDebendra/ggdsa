package com.dsa.ds11stack;

public class _05TwoStacksInAnArray {
    int[] arr;
    int capacity;
    int top1,top2;
    _05TwoStacksInAnArray(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        top1 = -1;
        top2 = capacity;
    }

    public void push1(int x){
        if (top1 < top2-1){
            arr[++top1] = x;
        }else {
            throw new IllegalStateException("Stack Overflow");
        }

    }

    public void push2(int x){
        if (top1 < top2-1){
            arr[--top2]=x;
        }else {
            throw new IllegalStateException("Stack Overflow");
        }
    }

    public int pop1(){
        if (top1>=0){
            return arr[top1--];
        }
        throw new IllegalStateException("Stack Underflow");
    }

    public int pop2(){
        if (top2<capacity){
            return arr[top2++];
        }
        throw new IllegalStateException("Stack Underflow");
    }

    public int size1(){
        return top1+1;
    }

    public int size2(){
        return capacity - top2;
    }

    public static void main(String[] args) {

        _05TwoStacksInAnArray stack = new _05TwoStacksInAnArray(5);

        // Stack1
        stack.push1(10);
        stack.push1(20);

        // Stack2
        stack.push2(50);
        stack.push2(40);

        System.out.println("Size1 : " + stack.size1()); // 2
        System.out.println("Size2 : " + stack.size2()); // 2

        System.out.println("Pop1 : " + stack.pop1()); // 20
        System.out.println("Pop2 : " + stack.pop2()); // 40

        System.out.println("Size1 : " + stack.size1()); // 1
        System.out.println("Size2 : " + stack.size2()); // 1

        stack.push1(30);
        stack.push2(60);

        System.out.println("Pop1 : " + stack.pop1()); // 30
        System.out.println("Pop1 : " + stack.pop1()); // 10

        System.out.println("Pop2 : " + stack.pop2()); // 60
        System.out.println("Pop2 : " + stack.pop2()); // 50
    }

}
