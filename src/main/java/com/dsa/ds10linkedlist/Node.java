package com.dsa.ds10linkedlist;

public class Node {
    public int data;
    public Node next;
    public Node prev;
    public Node random;
    public int key;
    public Node(int data){
        this.data=data;
    }
    public Node(int key, int data){
         this.key = key;
         this.data = data;
    }
}
