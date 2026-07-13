package com.dsa.ds11stack;

public class _06KStacksUsingArray {
    int[] arr, next, top;
    int capacity;
    int k;
    int free;
    _06KStacksUsingArray(int capacity, int k){
        this.capacity = capacity;
        this.k = k;
        free = 0;
        arr = new int[capacity];
        next = new int[capacity];
        top = new int[k];

        for (int i=0;i<k;i++){
            top[i] = -1;
        }

        for (int i=0;i<capacity-1;i++){
            next[i] = i+1;
        }
        next[capacity-1] = -1;
    }

    public boolean isEmpty(int sn){
        return top[sn] == -1;
    }

    public boolean isFull(){
        return free == -1;
    }

    public void push(int x, int sn){
        if (isFull()){
            throw new IllegalStateException("Overflow!");
        }
        int index = free;
        free = next[index];
        next[index] = top[sn];
        top[sn] = index;
        arr[index] = x;

    }


    public int pop(int sn){
        if (isEmpty(sn)){
            throw new IllegalStateException("Underflow!");
        }
        int index = top[sn];
        top[sn] = next[index];
        next[index] = free;
        free = index;
        return arr[index];

    }

    public int peek(int sn){
        if (isEmpty(sn)){
            throw new IllegalStateException("Empty Sack!");
        }
        int index = top[sn];
        return arr[index];

    }

    public static void main(String[] args) {

        _06KStacksUsingArray ks =
                new _06KStacksUsingArray(10,3);

        ks.push(10,0);
        ks.push(20,0);

        ks.push(30,1);
        ks.push(40,1);

        ks.push(50,2);
        ks.push(60,2);

        System.out.println(ks.pop(0)); //20
        System.out.println(ks.pop(1)); //40
        System.out.println(ks.pop(2)); //60

        ks.push(70,2);

        System.out.println(ks.pop(2)); //70
        System.out.println(ks.pop(2)); //50

    }
}
