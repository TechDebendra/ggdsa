package com.dsa.ds13dequeue;

import java.util.Deque;
import java.util.LinkedList;

public class _03DataStructureWithMinAndMaxOperations {

    Deque<Integer> deque;

    public  _03DataStructureWithMinAndMaxOperations(){
        deque = new LinkedList<>();
    }

    public void insertMin(int data){
        deque.offerFirst(data);
    }

    public void insertMax(int data){
        deque.offerLast(data);
    }

    public int getMin(){
        return deque.peekFirst();
    }

    public int getMax(){
        return deque.peekLast();
    }

    public int extractMin(){
        return deque.pollFirst();
    }

    public int extractMax(){
        return deque.pollLast();
    }

    public static void main(String[] args) {

        _03DataStructureWithMinAndMaxOperations ds =
                new _03DataStructureWithMinAndMaxOperations();

        ds.insertMax(10);
        ds.insertMax(20);
        ds.insertMax(30);

        ds.insertMin(5);
        ds.insertMin(2);
        ds.insertMin(1);

        System.out.println("Min : " + ds.getMin());   // 1
        System.out.println("Max : " + ds.getMax());   // 30

        System.out.println("Extract Min : " + ds.extractMin()); // 1
        System.out.println("Extract Max : " + ds.extractMax()); // 30

        System.out.println("Min : " + ds.getMin());   // 2
        System.out.println("Max : " + ds.getMax());   // 20
    }

}
