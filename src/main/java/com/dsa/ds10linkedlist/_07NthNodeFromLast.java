package com.dsa.ds10linkedlist;

public class _07NthNodeFromLast {
    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);
        head.next.next.next.next = new Node(50);

        nthNode(head, 1);
        nthNode(head, 2);
        nthNode(head, 3);
        nthNode(head, 5);
        nthNode(head, 6);
    }
    public static void  nthNode(Node head, int position){
        if (position <= 0) {
            throw new IllegalArgumentException("Position must be greater than 0");
        }
        if (head == null){
            return;
        }
        Node slowPtr = head;
        Node fastPtr = head;
        int n = position;
        while (position >= 1){
            if (fastPtr == null){
                return;
            }
            fastPtr = fastPtr.next;
            position--;
        }
        while (fastPtr != null){
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next;
        }

        System.out.println("Node "+n+" from last is :"+ slowPtr.data);
    }
}
