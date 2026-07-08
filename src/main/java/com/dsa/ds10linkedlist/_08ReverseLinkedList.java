package com.dsa.ds10linkedlist;

import static com.dsa.ds10linkedlist._05InsertIntoSortedLinkedList.printList;

public class _08ReverseLinkedList {

    public static void main(String[] args) {

        Node head = new Node(10);
        head.next = new Node(20);
        head.next.next = new Node(30);
        head.next.next.next = new Node(40);

        System.out.println("Original List:");
        printList(head);

        head = reverse(head);

        System.out.println("Reversed List:");
        printList(head);
    }

    public static Node reverse(Node head){
        if (head == null){
            return head;
        }

        Node prev = null;
        Node current = head;

        while (current !=null ) {
            Node temp = current.next;
            current.next = prev;
            prev = current;
            current = temp;
        }

        return prev;
    }
}
