package com.dsa.ds10linkedlist;

public class _04DoubleCircularLinkedList {
    public static void main(String[] args) {

    }

    public static Node insertAtFirst(Node head, int data){
        Node temp = new Node(data);

        if (head == null){
            temp.next = temp;
            temp.prev = temp;
            return temp;
        }

        temp.next = head;
        head.prev.next = temp;
        temp.prev = head.prev;
        head.prev = temp;

        return temp;
    }


}
